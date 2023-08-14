
package com.example.demo.controller;
import com.example.demo.model.Account;
import com.example.demo.model.AccountResponse;
import com.example.demo.service.RegisterService;
import com.example.demo.util.TokenGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.dozer.DozerBeanMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Gev
 */
@RestController
@RequestMapping("/api/v2/accounts")
@Slf4j
public class RegisterController {

    DozerBeanMapper mapper;

    public void before() throws Exception {
        mapper = new DozerBeanMapper();
    }

    @Autowired
    private RegisterService accountService;

    @PutMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(
            @RequestBody(required = true) Account registerRequest
    ) throws Exception {

        Optional<Account> doRegister = accountService.registerAccount(registerRequest);
        if (doRegister.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(doRegister.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(("Could not register user"));
    }

    @GetMapping("signIn")
    public ResponseEntity signIn(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String password) {
        TokenGenerator tokenObj = new TokenGenerator();
        String generateToken = tokenObj.generateToken(email);
        log.info("token = " + generateToken);
        Account user = accountService.findByMailAndByPassword(email, password);
        
        if (user!= null) {
            AccountResponse response = new AccountResponse();
            response.setEmail(user.getEmail());
            response.setId(user.getId());
            response.setPassword(user.getPassword());
//                    mapper.map(findByMailAndByPassword, AccountResponse.class);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("pls correct email or password!");
        }
    }

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addAccount(
            @RequestBody(required = true) Account registerRequest
    ) throws Exception {

        Optional<Account> doRegister = accountService.registerAccount(registerRequest);
        if (doRegister.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(doRegister.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(("Could not register user"));
    }

    @GetMapping(path = "/findByEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByEmail(String email) {
        if (email == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could find without mail");
        }
        return ResponseEntity.ok(this.accountService.findByMail(email));
    }
    
    @GetMapping("/sign-out")
    public ResponseEntity<String> signOut(@RequestParam(required = true) final String id) {
        Optional<Account> findById = accountService.findById(id);
        if(findById.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("operation passed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("operation failed");
        }
        
    }
    
    @DeleteMapping("deactivateAccount")
    public ResponseEntity<String>remoeAccount(
    @RequestParam(required = true) final String id 
    ) {
        boolean isDeleted = accountService.deleteById(id);
        if(isDeleted == true) {
            
            return ResponseEntity.status(HttpStatus.OK).body("deactivation passed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("deactivation failed");
        }
    }
}
