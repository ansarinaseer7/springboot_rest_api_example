
package nas.ans.springboot_rest_call_example.exception;

/**
 * @author ansar
 *
 */
public class RestApiException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public RestApiException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
}
