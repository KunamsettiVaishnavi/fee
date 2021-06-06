package com.g3.spc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.g3.spc.entities.Fee;
import com.g3.spc.entities.FeeInstallment;
import com.g3.spc.repository.IFeeInstallmentRepository;
import com.g3.spc.repository.IFeeRepository;

@SpringBootTest
public class FeeInstallmentServiceImplTest {
	
	IFeeInstallmentRepository repo1;
	
	private static IFeeInstallmentServiceImpl feeInsService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit() {
		repo1 = mock(IFeeInstallmentRepository.class);
		
		
		feeInsService = new IFeeInstallmentServiceImpl(repo1);
		
		
		ac = MockitoAnnotations.openMocks(this);
		
	}
	@AfterEach
	public void doEnd() throws Exception{
		ac.close();
	}
	
	
	@Test
	//@Disabled
	@DisplayName("Test-Save Fee")
	void testretrieveFeeInstallmentById() {
		/*
		FeeInstallment f = new FeeInstallment(101,10000,LocalDate.of(2021, 04, 9),LocalDate.of(2020, 03, 01),1);
		List<FeeInstallment> flist = new ArrayList<>();
		flist.add(f);
		Fee input = new Fee(11,40000,10000, 50000,flist);
		Fee output = new Fee(11,40000,10000, 50000,flist);
		*/
		int input = 101;
		FeeInstallment feeins = mock(FeeInstallment.class);
		Optional<FeeInstallment> fi = Optional.of(feeins);
		when(repo1.findById(input)).thenReturn(fi);
		feeInsService.retrieveFeeInstallmentById(input);
	}

}
