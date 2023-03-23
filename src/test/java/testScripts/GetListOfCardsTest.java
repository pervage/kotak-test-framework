package testScripts;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.qa.framework.base.ApiBaseClass;
import org.qa.framework.utilities.CommonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class GetListOfCardsTest extends ApiBaseClass {
    @Test
    public void getListofCards(){
        Response response = getRequestSpecs()
                .baseUri(CommonUtils.getPropValue("host_url"))
                .basePath(CommonUtils.getPropValue("base_path"))
                .get(CommonUtils.getPropValue("commercial_cards"));
        Assert.assertEquals(HttpStatus.SC_OK,response.statusCode());
        log.info("Total Number of Cards are -->{}",response.jsonPath().getString("originalSize"));
    }

    @Test
    public void getSessionId(){
        Response response = getRequestSpecs()
                .baseUri(CommonUtils.getPropValue("session_host_url"))
                .basePath(CommonUtils.getPropValue("json_mbox"))
                .queryParam("mbox","target-global-mbox")
                .queryParam("mboxSession","2ae4e6f827664db2912e8b0ddb9cfe99")
                .queryParam("mboxPC","385")
                .get();
        Assert.assertEquals(HttpStatus.SC_OK,response.statusCode());
        log.info("Session Id Returned : {}",response.getSessionId());
    }
}
