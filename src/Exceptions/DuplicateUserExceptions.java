package Exceptions;

public class DuplicateUserExceptions extends Exception {


	public String errorInfo;

	public DuplicateUserExceptions(String errorInfo){
		this.errorInfo=errorInfo;
	}

	public String getErrorInfo() {
		System.out.println("errorInfo");
		return errorInfo;
	}
}
