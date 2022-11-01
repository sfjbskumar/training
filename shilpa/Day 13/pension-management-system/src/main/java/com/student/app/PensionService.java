package com.student.app;

import java.util.ArrayList;
import java.util.List;

//import com.sagar.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

//import com.sagar.demo.model.Student;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class PensionService
{
    @Autowired
    PensionRepository repo;

    public Pension createApplicant(Pension p)
    {
         return repo.save(p);
    }

    public Pension getApplicantById(int id)
    {
        return repo.findById(id).get();
    }

    public String delete(int id)
    {
        repo.deleteById(id);
        return "Delete Success";
    }
    public List<Pension> getAllApplicants()
    {
        List<Pension> applicants = new ArrayList<>();
        repo.findAll().forEach(applicants::add);
        return applicants;
    }
    public String getStatus(int id){
        Optional<Pension> res=repo.findById(id);
        Pension re=res.get();
        String result=re.getEmp_status();
        return result;
    }
    public int getBalanceDetails(int id){
        Optional<Pension> res=repo.findById(id);
        Pension re=res.get();
        int result=re.getBalance_amount();
        return result;
    }

    public Pension createOrUpdate(Pension p) {

        return repo.save(p);

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

        repo.issuePension("R","Y", currentMMYY, previousMMYY);
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

        repo.loadPension("A","N", currentMMYY, previousMMYY);
    }


    public String approveApplication(int id) {
        if(repo.getEmp_status(id).equals("R")){
            repo.approveApplication("Y", id);
            return "Approval success.";
        }
        else{
            return "Approval failed.";
        }
    }



  }





