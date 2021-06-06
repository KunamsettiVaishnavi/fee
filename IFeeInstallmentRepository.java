package com.g3.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3.spc.entities.Fee;
import com.g3.spc.entities.FeeInstallment;
import com.g3.spc.entities.Student;

public interface IFeeInstallmentRepository extends JpaRepository<FeeInstallment, Integer> {
	/*
	public FeeInstallment makePayment(FeeInstallment feeInstallment);
	public List<FeeInstallment> pendingInstallments(Student student);
	public FeeInstallment retrieveFeeInstallmentById(int id);
	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(Fee fee);
	*/
}
