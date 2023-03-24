package testScripts;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.qa.framework.base.ApiBaseClass;
import org.qa.framework.entities.ResponseOutput;
import org.qa.framework.utilities.CommonUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.Listener;

@Slf4j
@Listeners({Listener.class})
public class CardsAPITest extends ApiBaseClass {
    @Test(description = "Validating the Schema of Card Output")
    public void getListOfCards(){
        Response response = getResponse();
        Assert.assertEquals(HttpStatus.SC_OK,response.statusCode());
        response.getBody().as(ResponseOutput.class);
        log.info("Response Schema Verified");
        log.info("Total Number of Cards are -->{}",response.jsonPath().getString("originalSize"));
    }

    @Test(description = "Validating Session Id")
    public void getSessionId(){
        String mboxSession = "2ae4e6f827664db2912e8b0ddb9cfe99";
        Response response = getRequestSpecs()
                .baseUri(CommonUtils.getPropValue("session_host_url"))
                .basePath(CommonUtils.getPropValue("json_mbox"))
                .queryParam("mbox","target-global-mbox")
                .queryParam("mboxSession",mboxSession)
                .queryParam("mboxPC","385")
                .get();
        Assert.assertEquals(HttpStatus.SC_OK,response.statusCode());
        Assert.assertEquals(mboxSession,response.getBody().jsonPath().getString("sessionId"));
        log.info("Session Id Returned : {}",response.getSessionId());
    }

    public Response getResponse(){
        return getRequestSpecs()
                .baseUri(CommonUtils.getPropValue("host_url"))
                .basePath(CommonUtils.getPropValue("base_path"))
                .get(CommonUtils.getPropValue("commercial_cards"));
    }
}
