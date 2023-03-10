/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.io.Serializable;

/**
 *
 * @author mariatahir
 */
public class ResponseData implements Serializable {

    private Boolean success = true;
    private String error = null;
    private Object response;

    public ResponseData(Boolean success, String error, String response) {
        this.success = success;
        this.error = error;
        this.response = response;
    }

    public ResponseData() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

}
