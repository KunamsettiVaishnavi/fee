package com.g3.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.spc.entities.Fee;
import com.g3.spc.entities.Student;
@Repository
public interface IFeeRepository extends JpaRepository<Fee, Integer> {
	/*
		public Fee addFee(Fee fee);
		public Fee deleteFee(int id);
		public Fee updateFee(Fee fee);
		public Fee retrieveFee(int id);
		public Fee retrieveFeeByStudent(Student student);
		public List<Fee> retrieveAllFeeByMonth(int month);
		
		*/
}
