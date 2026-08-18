package modelo.mainexceptions;

public class CadastradorExceptions extends Exception{
	private static final long serialVersionUID = 1L;

	public CadastradorExceptions(String msg) {
		super(msg);
	}
	
	public CadastradorExceptions(Throwable cause) {
		super(cause);
	}
	
	public CadastradorExceptions(String msg, Throwable cause){
		super(msg, cause);
	}
}
