package com.g3.spc.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.spc.entities.Fee;
import com.g3.spc.entities.FeeInstallment;
import com.g3.spc.exception.FeePaymentNotDoneException;
import com.g3.spc.service.IFeeInstallmentService;
import com.g3.spc.service.IFeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "Parent Teacher Communication Application",description = "various api to work on application")
public class FeeController {
	Logger log = org.slf4j.LoggerFactory.getLogger(FeeController.class);
			
	@Autowired
	private IFeeService feeservice;
	
	@Autowired
	private IFeeInstallmentService feeinstallmentservice;
	
	@GetMapping("/home")
	public String home() {
		return "welcome";		
	}
	
	@ApiOperation(value = "fee post mapping" , response = Fee.class)
	@PostMapping("/fee")
	public Fee addFee(@RequestBody @Valid Fee fee) { 
		log.info("insert fee");
		/*
		System.out.println("addfee Fee"+fee);
		Optional<Fee> optionalFee = feeservice.addFee(fee);
		Order order1 = optionalOrder.get();
		FeeDTO feeDto = feeservice.displayOrderDetails(order1);
		return FeeDto;
		*/
		return feeservice.addFee(fee);
	}
	
	@ApiOperation(value = "fee delete mapping" , response = Fee.class)
	@GetMapping("/deletefee/{feeId}") 
	public Fee deleteFee(@RequestBody Fee fee) {
		return feeservice.deleteFee(fee);
	}
	/*
	public Fee deleteFee(@PathVariable int feeId) {
		return feeservice.deleteFee(feeId);
	}
	*/
	@ApiOperation(value = "fee update mapping" , response = Fee.class)
	@PutMapping("/fee") 
	public Fee updateFee(@RequestBody Fee fee) {
		return feeservice.updateFee(fee);
	}
	
	@ApiOperation(value = "fee get mapping fetch my fee Id" , response = Fee.class)
	@GetMapping("/fee/{feeId}") 
	public Fee retrieveFee(@PathVariable int feeId) {
		return feeservice.retrieveFee(feeId);
	}
	
	@ApiOperation(value = "fee get mapping fetch by month" , response = List.class)
	@GetMapping("/month/{month}") 
	public List<Fee> retrieveAllFeeByMonth(@PathVariable int month)
	{
		return feeservice.retrieveAllFeeByMonth(month);
	}
	
	@GetMapping("/viewall/{feeId}") 
	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(@RequestBody Fee fee){
		return feeservice.retrieveAllFeeInstallmentsByFee(fee);
	}
	
	@ApiOperation(value = "feeinstallment post mapping" , response = FeeInstallment.class)
	@PostMapping("/feeinstallment") 
	public FeeInstallment makePayment(@RequestBody FeeInstallment feeInstallment) throws FeePaymentNotDoneException{
		
		System.out.println("makePayment FeeInstallment"+feeInstallment);
		//feeIdwtoPayment fetch fee
		
		Fee f = feeservice.retrieveFee(feeInstallment.getFeeIdwtoPayment());
		feeInstallment.setFee(f);
				
		
		return feeinstallmentservice.makePayment(feeInstallment);
	}
	
	@ApiOperation(value = "feeinstallment get mapping fetch by feeinstallment Id" , response = FeeInstallment.class)
	@GetMapping("/feeinstallment/{id}") 
	public FeeInstallment retrieveFeeInstallmentById(@PathVariable int id) {
		
		return feeinstallmentservice.retrieveFeeInstallmentById(id);
	}
}
