package com.mascotas.back.exception.payload;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApiResponse {

    private Date tiempo = new Date();
    private String mensaje;
    private String url;

    public ApiResponse(String mensaje, String url) {
        this.mensaje = mensaje;
        this.url = url.replace("uri=", "");
    }

}