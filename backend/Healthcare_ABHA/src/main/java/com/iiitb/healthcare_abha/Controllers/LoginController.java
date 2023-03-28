package com.iiitb.healthcare_abha.Controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iiitb.healthcare_abha.Init_auth_json_body.InitJson;
import com.iiitb.healthcare_abha.Init_auth_json_body.Query;
import com.iiitb.healthcare_abha.Init_auth_json_body.Requester;
import com.iiitb.healthcare_abha.JasonTokenHelper.AccessToken;
import com.iiitb.healthcare_abha.JsonHelper.JsonLoginCarrier;
import com.iiitb.healthcare_abha.JsonHelper.Root;
import com.iiitb.healthcare_abha.JsonHelper.login_cred;
import com.iiitb.healthcare_abha.NgrokJasonHelper.Root2;
import com.iiitb.healthcare_abha.OnConform_body.Credential;
import com.iiitb.healthcare_abha.OnConform_body.OnConfirmBody;
import com.iiitb.healthcare_abha.Service.LoginService;
import jakarta.persistence.Access;
import lombok.Data;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;


import java.net.http.HttpRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Data
@Controller
@CrossOrigin(maxAge = 3600)
public class LoginController {

    @Autowired
    private LoginService loginService;
    private String accessToken;

    private String transactionId;
    private Root2 on_init_response;
    private Root on_confirm_response;
    private int init_status;
    private int confirm_status;

    private String abha_id;


    @ResponseBody
    @PostMapping("/")
  public ResponseEntity<Root2> ngrok_main(@RequestBody login_cred loginCred) throws JsonProcessingException {
      init_status = 0;
      //System.out.println(req);
      System.out.println();
      on_init_response = new Root2();
      on_confirm_response = new Root();
      abha_id = loginCred.getAbha();
      Map<String, String> body= new HashMap<String, String>();
// "clientId": "SBX_002039",
//    "clientSecret": "216f7db8-6695-46d9-92b1-44f050dcd212"
//Set your request body params

      //String encodedAuth=accessToken.getAccessToken();
      //System.out.println(encodedAuth);
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.setAccept(Collections.singletonList(MediaType.ALL));
      //headers.add("Authorization", "Bearer " + encodedAuth);
      body.put("clientId", "SBX_002039");
      body.put("clientSecret","216f7db8-6695-46d9-92b1-44f050dcd212");
      String curr_body=new ObjectMapper().writeValueAsString(body);
      HttpEntity<String> httpEntity = new HttpEntity<>(curr_body, headers);
      ResponseEntity<AccessToken> accessToken1=restTemplate.exchange("https://dev.abdm.gov.in/gateway/v0.5/sessions", HttpMethod.POST, httpEntity, AccessToken.class);
      accessToken =accessToken1.getBody().getAccessToken();
      System.out.println(accessToken);
      SessionController();
      //RedirectView redirectView = new RedirectView("/sessions", true);
      //return redirectView;
      //return "redirect:";
      //return result;
        while(init_status==0){}
        return new ResponseEntity<Root2>(on_init_response, HttpStatus.OK);

   }
    //"url": "https://586f-119-161-98-68.in.ngrok.io"


    //@ResponseBody
    //@PostMapping("/sessions")
    public void  SessionController() throws JsonProcessingException {
        System.out.println("SessionController+++++++called");
       String encodedAuth=accessToken;
       System.out.println(encodedAuth);

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        //restTemplate.setRequestFactory(new HttpCo);
       HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.add("Authorization", "Bearer " + encodedAuth);
        Map<String, String> body= new HashMap<String, String>();

//Set your request body params
        body.put("url", "https://f706-119-161-98-68.in.ngrok.io");
        String curr_body=new ObjectMapper().writeValueAsString(body);

        HttpEntity<String> httpEntity = new HttpEntity<>(curr_body, headers);
        ResponseEntity<Object> result=restTemplate.exchange("https://dev.abdm.gov.in/devservice/v1/bridges", HttpMethod.PATCH, httpEntity, Object.class);
        System.out.println(result.getStatusCode());
        Init_Auth();
        //RedirectView redirectView = new RedirectView("/init", true);
        //return redirectView;
           //return "redirect:";
    }


    @ResponseBody
    @PostMapping("/confirm/{otp}")
    public ResponseEntity<Root> Confirm_Auth(@PathVariable String otp) throws JsonProcessingException {

        String encodedAuth=accessToken;
        System.out.println("Confirm++++++++++++called");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.add("X-CM-ID","sbx");
        headers.add("Authorization", "Bearer " + encodedAuth);
        //headers.add("Authorization", "Bearer " + encodedAuth);
        //Map<String, Object> body= new HashMap<String, Object>();
        //InitJson initJson=new InitJson();


//const moment = require(‘moment’);
//pm.globals.set(“timestamp”, moment.utc().format(“YYYY-MM-DDTHH:mm:ss.SSSSSS”));
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        //initJson.requestId = randomUUIDString;
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.SSSSSS");
        df.setTimeZone(tz);
        String nowasISO = df.format(new Date());
        System.out.println(nowasISO);
        //initJson.timestamp=nowasISO;


        Credential credential = new Credential();
        credential.setAuthCode(otp);
        OnConfirmBody onConfirmBody = new OnConfirmBody();
        onConfirmBody.setCredential(credential);
        onConfirmBody.setTimestamp(nowasISO);
        onConfirmBody.setRequestId(randomUUIDString);
        onConfirmBody.setTransactionId(transactionId);

        String curr_body=new ObjectMapper().writeValueAsString(onConfirmBody);
        HttpEntity<String> httpEntity = new HttpEntity<>(curr_body, headers);
        ResponseEntity<Root>result=restTemplate.exchange("https://dev.abdm.gov.in/gateway/v0.5/users/auth/confirm", HttpMethod.POST, httpEntity, Root.class);

        System.out.println(result.getStatusCode());
        //System.out.println(result.getBody().getAuth().getPatient().name);
        while(confirm_status==0){}
        return new ResponseEntity<Root>(on_confirm_response, HttpStatus.OK);
    }
   // @ResponseBody
    //@PostMapping ("/init")
    public String Init_Auth() throws JsonProcessingException {
        String encodedAuth=accessToken;
        System.out.println("initauth++++++++++++called");
        //ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new HttpComponentsClientHttpRequestFactory());
        //HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        //RestTemplate restTemplate = new RestTemplate(factory);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.add("X-CM-ID","sbx");
        headers.add("Authorization", "Bearer " + encodedAuth);
        //headers.add("Authorization", "Bearer " + encodedAuth);
        //Map<String, Object> body= new HashMap<String, Object>();
        InitJson initJson=new InitJson();


//const moment = require(‘moment’);
//pm.globals.set(“timestamp”, moment.utc().format(“YYYY-MM-DDTHH:mm:ss.SSSSSS”));
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        initJson.requestId = randomUUIDString;
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.SSSSSS");
        df.setTimeZone(tz);
        String nowasISO = df.format(new Date());
        System.out.println(nowasISO);
        initJson.timestamp=nowasISO;
        Requester requester = new Requester();
        requester.setId("savy 2");
        requester.setType("HIU");

        Query query = new Query();
        query.setId(abha_id);
        query.setPurpose("KYC");
        query.setAuthMode("MOBILE_OTP");;
        query.setRequester(requester);
        initJson.setQuery(query);


        String curr_body=new ObjectMapper().writeValueAsString(initJson);
        HttpEntity<String> httpEntity = new HttpEntity<>(curr_body, headers);

        ResponseEntity<Root2>root2=restTemplate.exchange("https://dev.abdm.gov.in/gateway/v0.5/users/auth/init", HttpMethod.POST, httpEntity, Root2.class);
        System.out.println(root2.getStatusCode());
        //transactionId=root2.getBody().getAuth().getTransactionId();
        //System.out.println(result);
        //root2

        return "200 ok";
//new ParameterizedTypeReference<List<Shinobi>>()

    }

    @ResponseBody
    @PostMapping("/v0.5/users/auth/on-init")
    public ResponseEntity<Root2> OnInit(@RequestBody Root2 root2){
        System.out.println("on-init++++++++++++++++called");
        System.out.println(root2);
      transactionId=root2.getAuth().getTransactionId();
      init_status = 1;
      on_init_response = root2;
      return new ResponseEntity<Root2>(root2, HttpStatus.OK);

  }
    @ResponseBody
    @PostMapping("/v0.5/users/auth/on-confirm")
    public ResponseEntity<Root> OnConfirm(@RequestBody Root root){
      System.out.println("on-confirm++++++++++++++++called");
         System.out.println(root);
        System.out.println(root.getAuth().getPatient().name);
        on_confirm_response=root;
        confirm_status = 1;
        return new ResponseEntity<Root>(root, HttpStatus.OK);

    }

}