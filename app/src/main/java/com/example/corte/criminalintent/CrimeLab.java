package com.example.corte.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    //singleton that creates CrimeLab if one does not already exist
    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();

        //Protype populates 100 Crimes into Crimelab
        for(int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); //every other one
            mCrimes.add(crime);
        }
    }

    //Returns list of crimes
    public List<Crime> getCrimes() {
        return mCrimes;
    }

    //Returns Crime based off id
    public Crime getCrime(UUID id){
        for (Crime crime: mCrimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }

}
