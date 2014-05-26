package cpnv.jav1.lima;

import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalDistributionActivity extends Activity {
	
	public static final String KEY_PERSON_ID = "1";
	public static final String ERROR_NO_EXTRAS = "No person ID given in the Intent";
	
	
	
	private LinearLayout _mainLayout;
	private TextView _txtTitle;
	private int _personId;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_distribution);
        
        /**
         *    INITIALIZATIONS
         */
        
        _txtTitle = (TextView) findViewById(R.id.persDis_txtTitle);
        _mainLayout = (LinearLayout) findViewById(R.id.persDis_mainLayout);
        _personId = getIntent().getExtras().getInt(KEY_PERSON_ID, -1); 
        if (_personId == -1)
			Toast.makeText(this, ERROR_NO_EXTRAS, Toast.LENGTH_LONG);
        
        
        /**
         *    WORKING WITH BDD
         */
        
        
        //getLoaderManager().initLoader(0, null, null);
        //http://developer.android.com/guide/components/loaders.html
        
        
        LimaDb db = new LimaDb("http://192.168.0.4");
        
        db.executeQuery("SELECT "
        		+ 	"personfirstname, personlastname, cpnvclassname, startyear "
        		+ "FROM person INNER JOIN groupmember ON idperson = fk_person "
        		+ 	"INNER JOIN cpnvgroup ON idgroup = groupmember.fk_group "
        		+ 	"INNER JOIN cpnvclass ON idgroup = cpnvclass.fk_group "
        		+ 	"INNER JOIN scolaryear ON fk_year = idscolaryear "
        		+ "WHERE idperson = "+ _personId);
        
        /**
         *   CONSTRUCT WINDOW TITLE
         */
        
        if ( db.moveNext() ) {
	        int startyear = Integer.parseInt( db.getField("startyear") );
	        _txtTitle.setText( db.getField("personlastname").toUpperCase(Locale.FRENCH) +" "+ db.getField("personfirstname") +" / "+ db.getField("cpnvclassname") +" / "+ startyear +" - "+ (startyear+1) );
        }
        else {
        	Toast.makeText(this, "ERROR reading database", Toast.LENGTH_SHORT).show(); // TODO: Change the Toast
        }
        
        
        
        /**
         *    CONSTRUCT BOOK LIST
         */
        
        db.executeQuery("SELECT "
        		+ 	"articlename, deliverystatus "
        		+ "FROM article INNER JOIN delivery ON idarticle = fk_article "
        		+ "INNER JOIN signature ON fk_signature = idsignature "
        		+ "WHERE fk_person = "+ _personId);
        
        LayoutInflater _inflater = LayoutInflater.from(this);
        while (db.moveNext()) {
	        
        	View entry = _inflater.inflate(R.layout.pers_dis_entry, null);
        	TextView txtBookName = (TextView) entry.findViewById(R.id.persDisEntry_txtBookName);
        	TextView txtStatus = (TextView) entry.findViewById(R.id.persDisEntry_txtStatus);
        	
        	try {
        		
				DeliveryStatus ds = new DeliveryStatus( Integer.parseInt(db.getField("deliverystatus")) );
	        	txtStatus.setText( ds.getDeliveryStatusString() );
	        	txtStatus.setBackgroundColor( ds.getDeliveryStatusColor() );
	        	
			} catch (NumberFormatException e) {
				Toast.makeText(this, "Error in delivery status id (id unknow)", Toast.LENGTH_LONG).show(); // TODO: Change the Toast
				e.printStackTrace();
			} catch (Exception e) {
				Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
        	
        	txtBookName.setText(db.getField("articlename"));
        	
        	
        	/**
        	 * Put onclick event on each book delivery status
        	 */
        	
        	txtStatus.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					final String deliveryStatus[] = DeliveryStatus.getDeliveryStatusStrings();
					
					AlertDialog.Builder builder = new Builder(PersonalDistributionActivity.this);
					builder.setTitle("Pick a status"); // TODO: Put this string in a file
					builder.setItems(deliveryStatus, new AlertDialog.OnClickListener() {
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							Toast.makeText(PersonalDistributionActivity.this, deliveryStatus[arg1], Toast.LENGTH_LONG).show();
						}
					});
					builder.create().show();
				}
			});
        	
        	
        	_mainLayout.addView(entry);
        }
        
	}

}
