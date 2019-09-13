package smartshare.commongateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartshare.commongateway.services.AuthenticationService;

import java.util.Map;

@RestController
@RequestMapping(path = "/",produces = "application/json")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    AuthenticationService service;

    @GetMapping(value="/")
    public String defaultMethod(RequestEntity request){
        return "Hello !";
    }

//    @GetMapping(value="**")
//    public ResponseEntity<Map<String, String>> testMethod(RequestEntity request){
//        System.out.println("inside");
//        System.out.println(request);
//
////        Have to sort out on HTTP status issue for correct and error result
//
//        return new ResponseEntity<>( service.processRequests(request),HttpStatus.OK);
//    }

    @RequestMapping(
            value = "**",
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public ResponseEntity<Map<String, String>> testPostMethod(RequestEntity request) {
        System.out.println("inside");
        System.out.println(request);

//        Have to sort out on HTTP status issue for correct and error result

        return new ResponseEntity<>( service.processRequests(request),HttpStatus.OK);
    }

//    @PostMapping(path = "/signUp", consumes = "application/json", produces = "application/json")
//    public void addMember(@RequestBody RequestEntity request ) {
//        System.out.println("inside");
//        System.out.println(request);
//    }
}
