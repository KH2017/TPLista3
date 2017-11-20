package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.SimpleDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.ThirdPartyDoor.DoorState;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.ThirdPartyDoor.LockStatus;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorAdapter implements Door {

	ThirdPartyDoor thirdPartyDoor;
	
	public ThirdPartyDoorAdapter() {
		thirdPartyDoor = new ThirdPartyDoor();
	}
	
	
/*	public static String DEFAULT_DOOR_CODE = "AAFF1299BFA";

	private String code = DEFAULT_DOOR_CODE;

	private boolean open = false;*/
	
	@Override
	public void open(String code) throws IncorrectDoorCodeException {
		try {
			thirdPartyDoor.unlock(code);
		}
		catch (CannotUnlockDoorException e){
			throw new IncorrectDoorCodeException();
		}
		try{
			thirdPartyDoor.setState(DoorState.OPEN);
		}
		catch (CannotChangeStateOfLockedDoor e) {
			
		}
	}

	@Override
	public void close() {
		try{
			thirdPartyDoor.setState(DoorState.CLOSED);
		}
		catch (CannotChangeStateOfLockedDoor e) {
			
		}
	}

	@Override
	public boolean isOpen() {
		if(thirdPartyDoor.getState() == DoorState.CLOSED)
			return false;
		else
			return true;
	}

	@Override
	public void changeCode(String oldCode, String newCode, String newCodeConfirmation)
			throws IncorrectDoorCodeException, CodeMismatchException {
		if (!newCode.equals(newCodeConfirmation)){
			throw new CodeMismatchException();
		}
		try{
			thirdPartyDoor.unlock(oldCode);
		}
		catch (CannotUnlockDoorException e){
			throw new IncorrectDoorCodeException();
		}
		try{
		thirdPartyDoor.setNewLockCode(newCode);
		}
		catch (CannotChangeCodeForUnlockedDoor f){
			throw new IncorrectDoorCodeException();
		}
		
	}

	@Override
	public boolean testCode(String code) {
		try {
			thirdPartyDoor.unlock(code);
		}
		catch (CannotUnlockDoorException e){
			return false;
		}
		
		thirdPartyDoor.lock();
		return true;
	}

}
