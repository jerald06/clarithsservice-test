
package com.clarit.hs.service.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler 
  implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
      throws IOException {

        return (
          httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
          || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) 
      throws IOException {

        if (httpResponse.getStatusCode()
          .series() == HttpStatus.Series.SERVER_ERROR) {
            // handle SERVER_ERROR
        } else if (httpResponse.getStatusCode()
          .series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle CLIENT_ERROR
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ItemNotFoundException(httpResponse.toString(),httpResponse.getStatusText());
            }
            else  if (httpResponse.getStatusCode() == HttpStatus.UNAUTHORIZED){
                throw new UnAuthorizedException("Unknown User","put valid id");
            }
            else if (httpResponse.getStatusCode()==HttpStatus.FORBIDDEN){
                throw new ForbiddenException("check your api","please check");
            }
        }
    }


}