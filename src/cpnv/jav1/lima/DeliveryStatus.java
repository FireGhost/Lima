package cpnv.jav1.lima;

import java.util.ArrayList;

import android.graphics.Color;

public class DeliveryStatus {
	
	
	public static final int TAKEN_ID = 2;
	public static final int NOT_TAKEN_ID = 3;
	public static final int NOT_AVAILABLE_ID = 4;
	
	public static final String TAKEN_STRING = "Taken";
	public static final String NOT_TAKEN_STRING = "Not taken";
	public static final String NOT_AVAILABLE_STRING = "Not available";
	
	public static final String ERROR_NO_EXISTANT = "This delivery status doesn't exist";
	
	
	private int _deliveryStatus;
	
	
	public DeliveryStatus(int deliveryStatus) throws Exception {
		setDeliveryStatus(deliveryStatus);
	}
	public DeliveryStatus(String deliveryStatusString) throws Exception {
		setDeliveryStatus(deliveryStatusString);
	}
	
	
	
	
	public int getDeliveryStatusColor() {
		switch (_deliveryStatus) {
		case TAKEN_ID:
			return Color.rgb(102, 255, 102);
			
		case NOT_TAKEN_ID:
			return Color.rgb(255, 102, 0);
			
		case NOT_AVAILABLE_ID:
			return Color.rgb(255, 0, 102);
		}
		
		return 0;
	}
	
	
	
	public ArrayList<String> getAllDeliveryStatus() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(TAKEN_ID, TAKEN_STRING);
		arr.add(NOT_TAKEN_ID, NOT_TAKEN_STRING);
		arr.add(NOT_AVAILABLE_ID, NOT_AVAILABLE_STRING);
		return arr;
	}
	
	
	public static String[] getDeliveryStatusStrings() {
		return new String[] {TAKEN_STRING, NOT_TAKEN_STRING, NOT_AVAILABLE_STRING};
	}
	
	
	
	public int getDeliveryStatus() {
		return _deliveryStatus;
	}
	public void setDeliveryStatus(int deliveryStatus) throws Exception {
		if (deliveryStatus < 1 || deliveryStatus > 4)
			throw new Exception(ERROR_NO_EXISTANT);
		else
			_deliveryStatus = deliveryStatus;
	}
	
	
	public String getDeliveryStatusString() {
		switch (_deliveryStatus) {
		case TAKEN_ID:
			return TAKEN_STRING;
			
		case NOT_TAKEN_ID:
			return NOT_TAKEN_STRING;
			
		case NOT_AVAILABLE_ID:
			return NOT_AVAILABLE_STRING;
		}
		
		return "";
	}
	public void setDeliveryStatus(String deliveryStatusString) throws Exception {
		if (deliveryStatusString.equals( TAKEN_STRING )) {
			_deliveryStatus = TAKEN_ID;
		}
		else if (deliveryStatusString.equals( NOT_TAKEN_STRING )) {
			_deliveryStatus = NOT_TAKEN_ID;
		}
		else if (deliveryStatusString.equals( NOT_AVAILABLE_STRING )) {
			_deliveryStatus = NOT_AVAILABLE_ID;
		}
		else {
			throw new Exception(ERROR_NO_EXISTANT);
		}
	}

}
