package com.lagrange.mediacenter.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Video not found")
public class VideoNotFoundException extends RuntimeException {

}