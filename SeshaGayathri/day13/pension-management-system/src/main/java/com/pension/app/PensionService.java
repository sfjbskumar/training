package com.pension.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PensionService
{
    @Autowired
    PensionRepository pensionRepository;
    Pension pension1;
    //getting all Pension records
    public List<Pension> getAllPension()
    {
        List<Pension> pensions = new ArrayList<>();
        pensionRepository.findAll().forEach(pension -> pensions.add(pension));
        return pensions;
    }
    //getting a specific record
    public Pension getPensionById(int id)
    {
                return pensionRepository.findById(id).get();
    }

    //adding a record
    public Pension saveOrUpdate(Pension pension)
    {
        return pensionRepository.save(pension);
    }
    //deleting a specific record
    public String delete(int id)
    {
        pensionRepository.deleteById(id);
        return "Delete Success.";
    }
    public String getStatus(int id){
        String result="Applicant Id: "+id+"\nEmployee Status: ";
        result=result+pensionRepository.getEmpStatus(id);
        result=result+"\nPensionStatus: ";
        result=result+pensionRepository.getPensionStatus(id);
        return result;
    }

    //getting balance details of the applicant
    public String getBalanceDetails(int id){
        return "Balance amount: Rs." + pensionRepository.getBalance(id)+
                "\nInstallment: Rs."+pensionRepository.getInstallment(id)+
                "\nPension month and year (MMYY): "+pensionRepository.getPensionMMYY(id);

    }

    //issuePension to all applicants with empStatus R and PensionStatus Y
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

    //loadPension to all applicants with empStatus A and PensionStatus N
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


    // Approve pension application if empStatus is R
    public String approveApplication(int id) {
        if(pensionRepository.getEmpStatus(id).equals("R")){
            pensionRepository.approveApplication("Y", id);
            return "Approval success.";
        }
        else{
            return "Approval failed.";
        }
    }
}



