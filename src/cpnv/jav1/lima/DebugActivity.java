package cpnv.jav1.lima;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DebugActivity extends Activity 
				   implements OnClickListener {

	// References on controls of this activity
	private Button _btn;
	private TextView _output;
	

    // Create activity event handler
	@Override
    public void onCreate(Bundle savedInstanceState) {
		// Initialize and display view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug);
        
        // Log messages (logcat)
        Log.i ("LIMA", "Started debug activity");
        
        // Setup event handler on action button
        _btn = (Button)findViewById(R.id.action1);
       	_btn.setOnClickListener(this);
        _btn = (Button)findViewById(R.id.action2); 
       	_btn.setOnClickListener(this);
        _btn = (Button)findViewById(R.id.action3); 
       	_btn.setOnClickListener(this);
       	_btn = (Button)findViewById(R.id.action4); 
       	_btn.setOnClickListener(this);
       	
       	// Get reference on the output textview
		_output = (TextView)findViewById(R.id.outputzone);
    }

	// Any click on this screen will invoke this handler
	@Override
	public void onClick(View btn) {
		int nbpts = 0;
		// Let's see which action must be performed
		switch (btn.getId()) 
		{
		case R.id.action1: // 
			_output.setText("Test des articles");
			Article art01 = new Article();
			Article art02 = new Article("Classeur",100,"Bernard","Office World",16.0,2.5); // Number, responsible, supplier, price, VAT
			Article art03 = new Article("XL",100,"Bernard","Office World",16.0,2.5);
			Article art04 = new Article("Classeur",-100,"Bernard","Office World",16.0,2.5);
			Article art05 = new Article("Classeur",100,"X","Office World",16.0,2.5);
			Article art06 = new Article("Classeur",100,"Bernard","X",16.0,2.5);
			Article art07 = new Article("Classeur",100,"Bernard","Office World",-16.0,2.5);
			Article art08 = new Article("Classeur",100,"Bernard","Office World",16.0,-2.5);
			Article art09 = new Article(art02);
			
			// Check behavior
			if ((art01.getNumber() == 0) && (art01.getResponsible().equals("A d�finir")) && (art01.getSupplier().equals("A d�finir")) && (art01.getPrice() == 0.0) && (art01.getVat() == 0.0)) nbpts++;
			if ((art02.getName().equals("Classeur")) && (art02.getNumber() == 100) && (art02.getResponsible().equals("Bernard")) && (art02.getSupplier().equals("Office World")) && (art02.getPrice() == 16.0) && (art02.getVat() == 2.5)) nbpts++;
			if ((art03.getName().equals("A d�finir")) && (art03.getNumber() == 100) && (art03.getResponsible().equals("Bernard")) && (art03.getSupplier().equals("Office World")) && (art03.getPrice() == 16.0) && (art03.getVat() == 2.5)) nbpts++;
			if ((art04.getName().equals("Classeur")) && (art04.getNumber() == 0) && (art04.getResponsible().equals("Bernard")) && (art04.getSupplier().equals("Office World")) && (art04.getPrice() == 16.0) && (art04.getVat() == 2.5)) nbpts++;
			if ((art05.getName().equals("Classeur")) && (art05.getNumber() == 100) && (art05.getResponsible().equals("A d�finir")) && (art05.getSupplier().equals("Office World")) && (art05.getPrice() == 16.0) && (art05.getVat() == 2.5)) nbpts++;
			if ((art06.getName().equals("Classeur")) && (art06.getNumber() == 100) && (art06.getResponsible().equals("Bernard")) && (art06.getSupplier().equals("A d�finir")) && (art06.getPrice() == 16.0) && (art06.getVat() == 2.5)) nbpts++;
			if ((art07.getName().equals("Classeur")) && (art07.getNumber() == 100) && (art07.getResponsible().equals("Bernard")) && (art07.getSupplier().equals("Office World")) && (art07.getPrice() == 0.0) && (art07.getVat() == 2.5)) nbpts++;
			if ((art08.getName().equals("Classeur")) && (art08.getNumber() == 100) && (art08.getResponsible().equals("Bernard")) && (art08.getSupplier().equals("Office World")) && (art08.getPrice() == 16.0) && (art08.getVat() == 0.0)) nbpts++;
			if ((art09.getName().equals("Classeur")) && (art09.getNumber() == 101) && (art09.getResponsible().equals("Bernard")) && (art09.getSupplier().equals("Office World")) && (art09.getPrice() == 16.0) && (art09.getVat() == 2.5)) nbpts++;
			art03.setName("Classeur");
			if ((art03.getName().equals("Classeur")) && (art03.getNumber() == 100) && (art03.getResponsible().equals("Bernard")) && (art03.getSupplier().equals("Office World")) && (art03.getPrice() == 16.0) && (art03.getVat() == 2.5)) 
			{
				art03.setName("XM");
				if ((art03.getName().equals("A d�finir")) && (art03.getNumber() == 100) && (art03.getResponsible().equals("Bernard")) && (art03.getSupplier().equals("Office World")) && (art03.getPrice() == 16.0) && (art03.getVat() == 2.5)) nbpts++;
			}
			art04.setNumber(100);
			if ((art04.getName().equals("Classeur")) && (art04.getNumber() == 100) && (art04.getResponsible().equals("Bernard")) && (art04.getSupplier().equals("Office World")) && (art04.getPrice() == 16.0) && (art04.getVat() == 2.5)) 
			{
				art04.setNumber(-100);
				if ((art04.getName().equals("Classeur")) && (art04.getNumber() == 0) && (art04.getResponsible().equals("Bernard")) && (art04.getSupplier().equals("Office World")) && (art04.getPrice() == 16.0) && (art04.getVat() == 2.5)) nbpts++;
			}
			art05.setResponsible("Bernard");
			if ((art05.getName().equals("Classeur")) && (art05.getNumber() == 100) && (art05.getResponsible().equals("Bernard")) && (art05.getSupplier().equals("Office World")) && (art05.getPrice() == 16.0) && (art05.getVat() == 2.5)) 
			{
				art05.setResponsible("X");
				if ((art05.getName().equals("Classeur")) && (art05.getNumber() == 100) && (art05.getResponsible().equals("A d�finir")) && (art05.getSupplier().equals("Office World")) && (art05.getPrice() == 16.0) && (art05.getVat() == 2.5)) nbpts++;
			}
			art06.setSupplier("Office World");
			if ((art06.getName().equals("Classeur")) && (art06.getNumber() == 100) && (art06.getResponsible().equals("Bernard")) && (art06.getSupplier().equals("Office World")) && (art06.getPrice() == 16.0) && (art06.getVat() == 2.5)) 
			{
				art06.setSupplier("X");
				if ((art06.getName().equals("Classeur")) && (art06.getNumber() == 100) && (art06.getResponsible().equals("Bernard")) && (art06.getSupplier().equals("A d�finir")) && (art06.getPrice() == 16.0) && (art06.getVat() == 2.5)) nbpts++;
			}
			art07.setPrice(16.0);
			if ((art07.getName().equals("Classeur")) && (art07.getNumber() == 100) && (art07.getResponsible().equals("Bernard")) && (art07.getSupplier().equals("Office World")) && (art07.getPrice() == 16.0) && (art07.getVat() == 2.5)) 
			{
				art07.setPrice(-16.0);
				if ((art07.getName().equals("Classeur")) && (art07.getNumber() == 100) && (art07.getResponsible().equals("Bernard")) && (art07.getSupplier().equals("Office World")) && (art07.getPrice() == 0.0) && (art07.getVat() == 2.5)) nbpts++;
			}
			art08.setVat(2.5);
			if ((art08.getName().equals("Classeur")) && (art08.getNumber() == 100) && (art08.getResponsible().equals("Bernard")) && (art08.getSupplier().equals("Office World")) && (art08.getPrice() == 16.0) && (art08.getVat() == 2.5)) 
			{
				art08.setVat(-2.5);
				if ((art08.getName().equals("Classeur")) && (art08.getNumber() == 100) && (art08.getResponsible().equals("Bernard")) && (art08.getSupplier().equals("Office World")) && (art08.getPrice() == 16.0) && (art08.getVat() == 0.0)) nbpts++;
			}
			if (art02.dump().equals("Classeur-100-Bernard-Office World-16.0-2.5")) nbpts++;

			// Write out result
			_output.setText(_output.getText()+"\nScore = "+nbpts+"/16");
			
			break;
		case R.id.action2: // 
			_output.setText("Test Books");
			
			Book book01 = new Book();
			Book book02 = new Book("XML For Dummies",3300,"Bernard","Payot",33.30,8.0,"987654321"); // Number, responsible, supplier, price, VAT, ISBN
			Book book03 = new Book("XL",3300,"Bernard","Payot",33.30,8.0,"987654321");
			Book book04 = new Book("XML For Dummies",-3300,"Bernard","Payot",33.30,8.0,"987654321");
			Book book05 = new Book("XML For Dummies",3300,"X","Payot",33.30,8.0,"987654321");
			Book book06 = new Book("XML For Dummies",3300,"Bernard","X",33.30,8.0,"987654321");
			Book book07 = new Book("XML For Dummies",3300,"Bernard","Payot",-33.30,8.0,"987654321");
			Book book08 = new Book("XML For Dummies",3300,"Bernard","Payot",33.30,-8.0,"987654321");
			Book book09 = new Book("XML For Dummies",3300,"Bernard","Payot",33.30,8.0,"9876");
			Book book10 = new Book(book02);
			
			// Check behavior

			if ((book01.getNumber() == 0) && (book01.getResponsible().equals("A d�finir")) && (book01.getSupplier().equals("A d�finir")) && (book01.getPrice() == 0.0) && (book01.getVat() == 0.0) && (book01.getIsbn() == "A d�finir")) nbpts++;
			if ((book02.getName().equals("XML For Dummies")) && (book02.getNumber() == 3300) && (book02.getResponsible().equals("Bernard")) && (book02.getSupplier().equals("Payot")) && (book02.getPrice() == 33.30) && (book02.getVat() == 8.0) && (book02.getIsbn() == "987654321")) nbpts++;
			if ((book03.getName().equals("A d�finir")) && (book03.getNumber() == 3300) && (book03.getResponsible().equals("Bernard")) && (book03.getSupplier().equals("Payot")) && (book03.getPrice() == 33.30) && (book03.getVat() == 8.0) && (book03.getIsbn() == "987654321")) nbpts++;
			if ((book04.getName().equals("XML For Dummies")) && (book04.getNumber() == 0) && (book04.getResponsible().equals("Bernard")) && (book04.getSupplier().equals("Payot")) && (book04.getPrice() == 33.30) && (book04.getVat() == 8.0) && (book04.getIsbn() == "987654321")) nbpts++;
			if ((book05.getName().equals("XML For Dummies")) && (book05.getNumber() == 3300) && (book05.getResponsible().equals("A d�finir")) && (book05.getSupplier().equals("Payot")) && (book05.getPrice() == 33.30) && (book05.getVat() == 8.0) && (book05.getIsbn() == "987654321")) nbpts++;
			if ((book06.getName().equals("XML For Dummies")) && (book06.getNumber() == 3300) && (book06.getResponsible().equals("Bernard")) && (book06.getSupplier().equals("A d�finir")) && (book06.getPrice() == 33.30) && (book06.getVat() == 8.0) && (book06.getIsbn() == "987654321")) nbpts++;
			if ((book07.getName().equals("XML For Dummies")) && (book07.getNumber() == 3300) && (book07.getResponsible().equals("Bernard")) && (book07.getSupplier().equals("Payot")) && (book07.getPrice() == 0.0) && (book07.getVat() == 8.0) && (book07.getIsbn() == "987654321")) nbpts++;
			if ((book08.getName().equals("XML For Dummies")) && (book08.getNumber() == 3300) && (book08.getResponsible().equals("Bernard")) && (book08.getSupplier().equals("Payot")) && (book08.getPrice() == 33.30) && (book08.getVat() == 0.0) && (book08.getIsbn() == "987654321")) nbpts++;
			if ((book09.getName().equals("XML For Dummies")) && (book09.getNumber() == 3300) && (book09.getResponsible().equals("Bernard")) && (book09.getSupplier().equals("Payot")) && (book09.getPrice() == 33.30) && (book09.getVat() == 8.0) && (book09.getIsbn() == "A d�finir")) nbpts++;
			if ((book10.getName().equals("XML For Dummies")) && (book10.getNumber() == 3301) && (book10.getResponsible().equals("Bernard")) && (book10.getSupplier().equals("Payot")) && (book10.getPrice() == 33.30) && (book10.getVat() == 8.0) && (book10.getIsbn() == "987654321")) nbpts++;
			book03.setName("XML For Dummies");
			if ((book03.getName().equals("XML For Dummies")) && (book03.getNumber() == 3300) && (book03.getResponsible().equals("Bernard")) && (book03.getSupplier().equals("Payot")) && (book03.getPrice() == 33.30) && (book03.getVat() == 8.0) && (book03.getIsbn() == "987654321")) 
			{
				book03.setName("XM");
				if ((book03.getName().equals("A d�finir")) && (book03.getNumber() == 3300) && (book03.getResponsible().equals("Bernard")) && (book03.getSupplier().equals("Payot")) && (book03.getPrice() == 33.30) && (book03.getVat() == 8.0) && (book03.getIsbn() == "987654321")) nbpts++;
			}
			book04.setNumber(3300);
			if ((book04.getName().equals("XML For Dummies")) && (book04.getNumber() == 3300) && (book04.getResponsible().equals("Bernard")) && (book04.getSupplier().equals("Payot")) && (book04.getPrice() == 33.30) && (book04.getVat() == 8.0) && (book04.getIsbn() == "987654321")) 
			{
				book04.setNumber(-3300);
				if ((book04.getName().equals("XML For Dummies")) && (book04.getNumber() == 0) && (book04.getResponsible().equals("Bernard")) && (book04.getSupplier().equals("Payot")) && (book04.getPrice() == 33.30) && (book04.getVat() == 8.0) && (book04.getIsbn() == "987654321")) nbpts++;
			}
			book05.setResponsible("Bernard");
			if ((book05.getName().equals("XML For Dummies")) && (book05.getNumber() == 3300) && (book05.getResponsible().equals("Bernard")) && (book05.getSupplier().equals("Payot")) && (book05.getPrice() == 33.30) && (book05.getVat() == 8.0) && (book05.getIsbn() == "987654321")) 
			{
				book05.setResponsible("X");
				if ((book05.getName().equals("XML For Dummies")) && (book05.getNumber() == 3300) && (book05.getResponsible().equals("A d�finir")) && (book05.getSupplier().equals("Payot")) && (book05.getPrice() == 33.30) && (book05.getVat() == 8.0) && (book05.getIsbn() == "987654321")) nbpts++;
			}
			book06.setSupplier("Payot");
			if ((book06.getName().equals("XML For Dummies")) && (book06.getNumber() == 3300) && (book06.getResponsible().equals("Bernard")) && (book06.getSupplier().equals("Payot")) && (book06.getPrice() == 33.30) && (book06.getVat() == 8.0) && (book06.getIsbn() == "987654321")) 
			{
				book06.setSupplier("X");
				if ((book06.getName().equals("XML For Dummies")) && (book06.getNumber() == 3300) && (book06.getResponsible().equals("Bernard")) && (book06.getSupplier().equals("A d�finir")) && (book06.getPrice() == 33.30) && (book06.getVat() == 8.0) && (book06.getIsbn() == "987654321")) nbpts++;
			}
			book07.setPrice(33.30);
			if ((book07.getName().equals("XML For Dummies")) && (book07.getNumber() == 3300) && (book07.getResponsible().equals("Bernard")) && (book07.getSupplier().equals("Payot")) && (book07.getPrice() == 33.30) && (book07.getVat() == 8.0) && (book07.getIsbn() == "987654321")) 
			{
				book07.setPrice(-33.30);
				if ((book07.getName().equals("XML For Dummies")) && (book07.getNumber() == 3300) && (book07.getResponsible().equals("Bernard")) && (book07.getSupplier().equals("Payot")) && (book07.getPrice() == 0.0) && (book07.getVat() == 8.0) && (book07.getIsbn() == "987654321")) nbpts++;
			}
			book08.setVat(8.0);
			if ((book08.getName().equals("XML For Dummies")) && (book08.getNumber() == 3300) && (book08.getResponsible().equals("Bernard")) && (book08.getSupplier().equals("Payot")) && (book08.getPrice() == 33.30) && (book08.getVat() == 8.0) && (book08.getIsbn() == "987654321")) 
			{
				book08.setVat(-8.0);
				if ((book08.getName().equals("XML For Dummies")) && (book08.getNumber() == 3300) && (book08.getResponsible().equals("Bernard")) && (book08.getSupplier().equals("Payot")) && (book08.getPrice() == 33.30) && (book08.getVat() == 0.0) && (book08.getIsbn() == "987654321")) nbpts++;
			}
			book09.setIsbn("987654321");
			if ((book09.getName().equals("XML For Dummies")) && (book09.getNumber() == 3300) && (book09.getResponsible().equals("Bernard")) && (book09.getSupplier().equals("Payot")) && (book09.getPrice() == 33.30) && (book09.getVat() == 8.0) && (book09.getIsbn() == "987654321")) 
			{
				book09.setIsbn("3465");
				if ((book09.getName().equals("XML For Dummies")) && (book09.getNumber() == 3300) && (book09.getResponsible().equals("Bernard")) && (book09.getSupplier().equals("Payot")) && (book09.getPrice() == 33.30) && (book09.getVat() == 8.0) && (book09.getIsbn() == "A d�finir")) nbpts++;
			}
			if (book02.dump().equals("XML For Dummies-3300-Bernard-Payot-33.3-8.0-987654321")) nbpts++;
			
			
			// Write out result
			_output.setText(_output.getText()+"\nScore = "+nbpts+"/18");
			
			break;
		case R.id.action3: // 
			_output.setText("Test Gear");
			
			Gear gear01 = new Gear();
			Gear gear02 = new Gear("Blouse",5800,"Herv�","H&M",72.10,8.0,"XXL"); // Number, responsible, supplier, price, VAT, size
			Gear gear03 = new Gear("XL",5800,"Herv�","H&M",72.10,8.0,"XXL");
			Gear gear04 = new Gear("Blouse",-5800,"Herv�","H&M",72.10,8.0,"XXL");
			Gear gear05 = new Gear("Blouse",5800,"X","H&M",72.10,8.0,"XXL");
			Gear gear06 = new Gear("Blouse",5800,"Herv�","X",72.10,8.0,"XXL");
			Gear gear07 = new Gear("Blouse",5800,"Herv�","H&M",-72.10,8.0,"XXL");
			Gear gear08 = new Gear("Blouse",5800,"Herv�","H&M",72.10,-8.0,"XXL");
			Gear gear09 = new Gear("Blouse",5800,"Herv�","H&M",72.10,8.0,"XXLXV");
			Gear gear10 = new Gear(gear02);
			
			// Check behavior

			if ((gear01.getNumber() == 0) && (gear01.getResponsible().equals("A d�finir")) && (gear01.getSupplier().equals("A d�finir")) && (gear01.getPrice() == 0.0) && (gear01.getVat() == 0.0) && (gear01.getSize().equals("U"))) nbpts++;
			if ((gear02.getName().equals("Blouse")) && (gear02.getNumber() == 5800) && (gear02.getResponsible().equals("Herv�")) && (gear02.getSupplier().equals("H&M")) && (gear02.getPrice() == 72.10) && (gear02.getVat() == 8.0) && (gear02.getSize() == "XXL")) nbpts++;
			if ((gear03.getName().equals("A d�finir")) && (gear03.getNumber() == 5800) && (gear03.getResponsible().equals("Herv�")) && (gear03.getSupplier().equals("H&M")) && (gear03.getPrice() == 72.10) && (gear03.getVat() == 8.0) && (gear03.getSize() == "XXL")) nbpts++;
			if ((gear04.getName().equals("Blouse")) && (gear04.getNumber() == 0) && (gear04.getResponsible().equals("Herv�")) && (gear04.getSupplier().equals("H&M")) && (gear04.getPrice() == 72.10) && (gear04.getVat() == 8.0) && (gear04.getSize() == "XXL")) nbpts++;
			if ((gear05.getName().equals("Blouse")) && (gear05.getNumber() == 5800) && (gear05.getResponsible().equals("A d�finir")) && (gear05.getSupplier().equals("H&M")) && (gear05.getPrice() == 72.10) && (gear05.getVat() == 8.0) && (gear05.getSize() == "XXL")) nbpts++;
			if ((gear06.getName().equals("Blouse")) && (gear06.getNumber() == 5800) && (gear06.getResponsible().equals("Herv�")) && (gear06.getSupplier().equals("A d�finir")) && (gear06.getPrice() == 72.10) && (gear06.getVat() == 8.0) && (gear06.getSize() == "XXL")) nbpts++;
			if ((gear07.getName().equals("Blouse")) && (gear07.getNumber() == 5800) && (gear07.getResponsible().equals("Herv�")) && (gear07.getSupplier().equals("H&M")) && (gear07.getPrice() == 0.0) && (gear07.getVat() == 8.0) && (gear07.getSize() == "XXL")) nbpts++;
			if ((gear08.getName().equals("Blouse")) && (gear08.getNumber() == 5800) && (gear08.getResponsible().equals("Herv�")) && (gear08.getSupplier().equals("H&M")) && (gear08.getPrice() == 72.10) && (gear08.getVat() == 0.0) && (gear08.getSize() == "XXL")) nbpts++;
			if ((gear09.getName().equals("Blouse")) && (gear09.getNumber() == 5800) && (gear09.getResponsible().equals("Herv�")) && (gear09.getSupplier().equals("H&M")) && (gear09.getPrice() == 72.10) && (gear09.getVat() == 8.0) && (gear09.getSize().equals("U"))) nbpts++;
			if ((gear10.getName().equals("Blouse")) && (gear10.getNumber() == 5801) && (gear10.getResponsible().equals("Herv�")) && (gear10.getSupplier().equals("H&M")) && (gear10.getPrice() == 72.10) && (gear10.getVat() == 8.0) && (gear10.getSize() == "XXL")) nbpts++;
			gear03.setName("Blouse");
			if ((gear03.getName().equals("Blouse")) && (gear03.getNumber() == 5800) && (gear03.getResponsible().equals("Herv�")) && (gear03.getSupplier().equals("H&M")) && (gear03.getPrice() == 72.10) && (gear03.getVat() == 8.0) && (gear03.getSize() == "XXL")) 
			{
				gear03.setName("XM");
				if ((gear03.getName().equals("A d�finir")) && (gear03.getNumber() == 5800) && (gear03.getResponsible().equals("Herv�")) && (gear03.getSupplier().equals("H&M")) && (gear03.getPrice() == 72.10) && (gear03.getVat() == 8.0) && (gear03.getSize() == "XXL")) nbpts++;
			}
			gear04.setNumber(5800);
			if ((gear04.getName().equals("Blouse")) && (gear04.getNumber() == 5800) && (gear04.getResponsible().equals("Herv�")) && (gear04.getSupplier().equals("H&M")) && (gear04.getPrice() == 72.10) && (gear04.getVat() == 8.0) && (gear04.getSize() == "XXL")) 
			{
				gear04.setNumber(-5800);
				if ((gear04.getName().equals("Blouse")) && (gear04.getNumber() == 0) && (gear04.getResponsible().equals("Herv�")) && (gear04.getSupplier().equals("H&M")) && (gear04.getPrice() == 72.10) && (gear04.getVat() == 8.0) && (gear04.getSize() == "XXL")) nbpts++;
			}
			gear05.setResponsible("Herv�");
			if ((gear05.getName().equals("Blouse")) && (gear05.getNumber() == 5800) && (gear05.getResponsible().equals("Herv�")) && (gear05.getSupplier().equals("H&M")) && (gear05.getPrice() == 72.10) && (gear05.getVat() == 8.0) && (gear05.getSize() == "XXL")) 
			{
				gear05.setResponsible("X");
				if ((gear05.getName().equals("Blouse")) && (gear05.getNumber() == 5800) && (gear05.getResponsible().equals("A d�finir")) && (gear05.getSupplier().equals("H&M")) && (gear05.getPrice() == 72.10) && (gear05.getVat() == 8.0) && (gear05.getSize() == "XXL")) nbpts++;
			}
			gear06.setSupplier("H&M");
			if ((gear06.getName().equals("Blouse")) && (gear06.getNumber() == 5800) && (gear06.getResponsible().equals("Herv�")) && (gear06.getSupplier().equals("H&M")) && (gear06.getPrice() == 72.10) && (gear06.getVat() == 8.0) && (gear06.getSize() == "XXL")) 
			{
				gear06.setSupplier("X");
				if ((gear06.getName().equals("Blouse")) && (gear06.getNumber() == 5800) && (gear06.getResponsible().equals("Herv�")) && (gear06.getSupplier().equals("A d�finir")) && (gear06.getPrice() == 72.10) && (gear06.getVat() == 8.0) && (gear06.getSize() == "XXL")) nbpts++;
			}
			gear07.setPrice(72.10);
			if ((gear07.getName().equals("Blouse")) && (gear07.getNumber() == 5800) && (gear07.getResponsible().equals("Herv�")) && (gear07.getSupplier().equals("H&M")) && (gear07.getPrice() == 72.10) && (gear07.getVat() == 8.0) && (gear07.getSize() == "XXL")) 
			{
				gear07.setPrice(-72.10);
				if ((gear07.getName().equals("Blouse")) && (gear07.getNumber() == 5800) && (gear07.getResponsible().equals("Herv�")) && (gear07.getSupplier().equals("H&M")) && (gear07.getPrice() == 0.0) && (gear07.getVat() == 8.0) && (gear07.getSize() == "XXL")) nbpts++;
			}
			gear08.setVat(8.0);
			if ((gear08.getName().equals("Blouse")) && (gear08.getNumber() == 5800) && (gear08.getResponsible().equals("Herv�")) && (gear08.getSupplier().equals("H&M")) && (gear08.getPrice() == 72.10) && (gear08.getVat() == 8.0) && (gear08.getSize() == "XXL")) 
			{
				gear08.setVat(-8.0);
				if ((gear08.getName().equals("Blouse")) && (gear08.getNumber() == 5800) && (gear08.getResponsible().equals("Herv�")) && (gear08.getSupplier().equals("H&M")) && (gear08.getPrice() == 72.10) && (gear08.getVat() == 0.0) && (gear08.getSize() == "XXL")) nbpts++;
			}
			gear09.setSize("XXL");
			if ((gear09.getName().equals("Blouse")) && (gear09.getNumber() == 5800) && (gear09.getResponsible().equals("Herv�")) && (gear09.getSupplier().equals("H&M")) && (gear09.getPrice() == 72.10) && (gear09.getVat() == 8.0) && (gear09.getSize() == "XXL")) 
			{
				gear09.setSize("XXXXXX");
				if ((gear09.getName().equals("Blouse")) && (gear09.getNumber() == 5800) && (gear09.getResponsible().equals("Herv�")) && (gear09.getSupplier().equals("H&M")) && (gear09.getPrice() == 72.10) && (gear09.getVat() == 8.0) && (gear09.getSize().equals("U"))) 
				{
					gear09.setSize("");
					if ((gear09.getName().equals("Blouse")) && (gear09.getNumber() == 5800) && (gear09.getResponsible().equals("Herv�")) && (gear09.getSupplier().equals("H&M")) && (gear09.getPrice() == 72.10) && (gear09.getVat() == 8.0) && (gear09.getSize().equals("U"))) nbpts++;
				}
			}
			if (gear02.dump().equals("Blouse-5800-Herv�-H&M-72.1-8.0-XXL")) nbpts++;
			
			
			// Write out result
			_output.setText(_output.getText()+"\nScore = "+nbpts+"/18");
			
			break;
		
		case R.id.action4:
			_output.setText("LimaDB testing...");
			
			LimaDb db = new LimaDb("http://192.168.0.4");
			
			_output.setText( _output.getText() +"\n\nSELECT * FROM cpnvclass");
			int nbrCpnvClass = db.executeQuery("SELECT * FROM cpnvclass");
			_output.setText( _output.getText() +"\nNbrAffectedRecords"+ nbrCpnvClass +"\n");
			
			for (int i = 0; i < nbrCpnvClass; i++)
				_output.setText( _output.getText() +"\n"+ db.moveNext() );
			
			break;
		}
	}
		
}
