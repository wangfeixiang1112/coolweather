package android.coolweather.com.coolweather.util;

import android.coolweather.com.coolweather.db.City;
import android.coolweather.com.coolweather.db.Country;
import android.coolweather.com.coolweather.db.Province;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017-8-1.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public  static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0 ; i < allProvinces.length(); i++ )
                {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProcessName(provinceObject.getString("name"));
                    province.setProcessCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */
    public  static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allCitys = new JSONArray(response);
                for (int i = 0 ; i < allCitys.length(); i++ )
                {
                    JSONObject cityObject = allCitys.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */
    public  static boolean handleCountryResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allCountrys = new JSONArray(response);
                for (int i = 0 ; i < allCountrys.length(); i++ )
                {
                    JSONObject countryObject = allCountrys.getJSONObject(i);
                    Country country = new Country();
                    country.setCountryName(countryObject.getString("name"));
                    country.setWeatherId(countryObject.getString("weather_id"));
                    country.setCityId(cityId);
                    country.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
