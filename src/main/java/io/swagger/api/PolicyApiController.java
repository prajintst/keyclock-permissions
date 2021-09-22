package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.model.ModelApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@RestController
@Api(tags = { "IntranetUser" })
@RequestMapping("/v1")
public class PolicyApiController implements PolicyApi {

    private static final Logger log = LoggerFactory.getLogger(PolicyApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PolicyApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ModelApiResponse> approveDocuments() {
        return getModelApiResponseResponseEntity();
    }


    public ResponseEntity<ModelApiResponse> approvePolicy() {
        return getModelApiResponseResponseEntity();
    }
    public ResponseEntity<ModelApiResponse> rejectPolicy() {
        return getModelApiResponseResponseEntity();
    }

    public ResponseEntity<ModelApiResponse> viewImages() {
        return getModelApiResponseResponseEntity();
    }

    public ResponseEntity<ModelApiResponse> updateImages() {
        return getModelApiResponseResponseEntity();
    }


    private ResponseEntity<ModelApiResponse> getModelApiResponseResponseEntity() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("{\n  \"details\" : \"details\",\n  \"message\" : \"message\",\n  \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\"\n}", ModelApiResponse.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelApiResponse>(HttpStatus.OK);
    }
}
