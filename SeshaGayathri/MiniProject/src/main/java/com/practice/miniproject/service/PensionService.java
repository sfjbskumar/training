package com.practice.miniproject.service;

import com.practice.miniproject.PensionRepository;
import com.practice.miniproject.model.PensionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class PensionService {
    @Autowired
    PensionRepository pensionRepository;
    //getting all student records
    public List<PensionModel> getAllPension()
    {
        List<PensionModel> pensions = new ArrayList<PensionModel>();
        pensionRepository.findAll().forEach(pension -> pensions.add(pension));
        return pensions;
    }
    //getting a specific record
    public PensionModel getPensionById(int id)
    {
        return pensionRepository.findById(id).get();
    }

    public PensionModel saveOrUpdate(PensionModel pension)
    {
        pensionRepository.save(pension);
        return pension;
    }
    //deleting a specific record
    public String delete(int id)
    {
        pensionRepository.deleteById(id);
        return "Delete Success";

    }
    public String getStatus(int id){
        String result="Applicant Id: "+id+"\nEmployee Status: ";
        result=result+pensionRepository.findById(id).get().getEmpstatus();
        result=result+"\nPensionStatus: ";
        result=result+pensionRepository.findById(id).get().getPenstatus();
        return result;
    }
    public String getBalanceDetails(int id){
        return "Balance amount: Rs." + pensionRepository.findById(id).get().getBalance()+
                "\nInstallment: Rs."+pensionRepository.findById(id).get().getInstallment()+
                "\nPension month and year (MMYY): "+pensionRepository.findById(id).get().getPenmmyy();

    }
    public void issuePension(){
        //current MMYY
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMyy");
        String currentMMYY = simpleDateFormat.format(new Date());

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        String currentMonth=monthFormat.format(new Date());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
        String currentYear=yearFormat.format(new Date());

        //previous MMYY
        int prevMonth = Integer.parseInt(currentMonth)-1;
        String previousMMYY = String.valueOf(prevMonth)+currentYear;
        if(previousMMYY.length()==3){
            previousMMYY = "0"+previousMMYY;
        }

        pensionRepository.issuePension("R","Y", currentMMYY, previousMMYY);
    }
    public String approveApplication(int id) {
        if(pensionRepository.findById(id).get().getEmpstatus().equals("R")){
            pensionRepository.approveApplication("Y", id);
            return "Approval success.";
        }
        else{
            return "Approval failed.";
        }
    }
    public void loadPension(){
        //current MMYY
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMyy");
        String currentMMYY = simpleDateFormat.format(new Date());

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        String currentMonth=monthFormat.format(new Date());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
        String currentYear=yearFormat.format(new Date());

        //previous MMYY
        int prevMonth = Integer.parseInt(currentMonth)-1;
        String previousMMYY = String.valueOf(prevMonth)+currentYear;
        if(previousMMYY.length()==3){
            previousMMYY = "0"+previousMMYY;
        }

        pensionRepository.loadPension("A","N", currentMMYY, previousMMYY);
    }
}



