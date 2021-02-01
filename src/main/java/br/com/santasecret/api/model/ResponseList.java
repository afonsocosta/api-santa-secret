package br.com.santasecret.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseList<T> {

    private int statusCode;
    private List<T> data;
    private long timeStamp;

    public ResponseList() {
        this.timeStamp = System.currentTimeMillis();
    }

}
