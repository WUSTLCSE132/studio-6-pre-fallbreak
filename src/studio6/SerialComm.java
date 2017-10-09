package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5

	public void writeByte(byte b) {
		try {
			port.writeByte(b);
			System.out.println(b);
		}
		catch (SerialPortException e) {
		}
	}
	// TODO: Add available() method

	public boolean available() {
		try {
			if (port.getInputBufferBytesCount() >= 1) {
				return true;
			}
		}
		catch (SerialPortException e) {
		}
		return false;
	}
	// TODO: Add readByte() method	
	
	public byte readByte(byte b){
		try {
			byte[] a = port.readBytes(port.getInputBufferBytesCount());
			return a[0];
		}
		catch (SerialPortException e) {
		}
		return (Byte) null;
	}
	// TODO: Add a main() method
	public void main() {
		try {
			SerialComm newObject = new SerialComm("");
			if (available()) {
				//readByte(newObject);
			}
		}
		catch (SerialPortException e) {
		}
	}
}
