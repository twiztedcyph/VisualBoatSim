package com.twizted.WeatherQuest;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.ArrayList;


/**
 * @author jsonschema2pojo.com
 * @author Ian Weeks
 */
@Generated("org.jsonschema2pojo")
public class Current
{

    @Expose
    private ArrayList<CurrentWeather> CurrentWeather = new ArrayList<CurrentWeather>();

    /**
     * @return The CurrentWeather
     */
    public ArrayList<CurrentWeather> getCurrentWeather()
    {
        return CurrentWeather;
    }

    /**
     * @param CurrentWeather The CurrentWeather
     */
    public void setCurrentWeather(ArrayList<CurrentWeather> CurrentWeather)
    {
        this.CurrentWeather = CurrentWeather;
    }

    /**
     * Get a string representation of this object.
     *
     * @return A string representation of this object.
     */
    @Override
    public String toString()
    {
        return "Current:\n" +
                "\t\tType               = " + "JOINT"                                   + "\n" +
                "\t\tIssued             = " + CurrentWeather.get(0).Issued              + "\n" +
                "\t\tTemperatureUnit    = " + CurrentWeather.get(0).TemperatureUnit     + "\n" +
                "\t\tVisibilityUnit     = " + CurrentWeather.get(0).VisibilityUnit      + "\n" +
                "\t\tRainfallUnit       = " + CurrentWeather.get(0).RainfallUnit        + "\n" +
                "\t\tWindSpeedUnit      = " + CurrentWeather.get(0).WindSpeedUnit       + "\n" +
                "\t\tWaveHeightUnit     = " + CurrentWeather.get(0).WaveHeightUnit      + "\n" +
                "\t\tWavePeriodUnit     = " + CurrentWeather.get(0).WavePeriodUnit      + "\n" +
                "\t\tLat                = " + CurrentWeather.get(0).Lat                 + "\n" +
                "\t\tLng                = " + CurrentWeather.get(0).Lng                 + "\n" +
                "\t\tSeaTemperature     = " + CurrentWeather.get(0).SeaTemperature      + "\n" +
                "\t\tSunRise            = " + CurrentWeather.get(0).SunRise             + "\n" +
                "\t\tSunSet             = " + CurrentWeather.get(0).SunSet              + "\n" +
                "\t\tDate               = " + CurrentWeather.get(1).Date                + "\n" +
                "\t\tTime               = " + CurrentWeather.get(1).Time                + "\n" +
                "\t\tWeatherSummary     = " + CurrentWeather.get(1).WeatherSummary      + "\n" +
                "\t\tAirTemperature     = " + CurrentWeather.get(1).AirTemperature      + "\n" +
                "\t\tVisibility         = " + CurrentWeather.get(1).Visibility          + "\n" +
                "\t\tWindSpeed          = " + CurrentWeather.get(1).WindSpeed           + "\n" +
                "\t\tGustSpeed          = " + CurrentWeather.get(1).GustSpeed           + "\n" +
                "\t\tWindDirection      = " + CurrentWeather.get(1).WindDirection       + "\n" +
                "\t\tPrecipitation      = " + CurrentWeather.get(1).Precipitation       + "\n" +
                "\t\tSigWaveHeight      = " + CurrentWeather.get(1).SigWaveHeight       + "\n" +
                "\t\tMeanWaveDirection  = " + CurrentWeather.get(1).MeanWaveDirection   + "\n" +
                "\t\tMeanWavePeriod     = " + CurrentWeather.get(1).MeanWavePeriod      + "\n" +
                "\t\tIcingRisk          = " + CurrentWeather.get(1).IcingRisk           + "\n" +
                "\t\tWeatherIcon        = " + CurrentWeather.get(1).WeatherIcon         + "\n";
    }

    /**
     * Get a string summary of this object.
     *
     * @return A string summary of this object.
     */
    public String getSummary()
    {
        return String.format("Lat: %.4f<br />" +
                        "Lon: %.4f<br />" +
                        "Wind speed: %s<br />" +
                        "Wind dir: %s<br />" +
                        "Wave height: %s<br />" +
                        "Wave dir: %s<br />" +
                        "Wave period: %s<br />",
                CurrentWeather.get(0).Lat, CurrentWeather.get(0).Lng, CurrentWeather.get(1).getWindSpeed(),
                CurrentWeather.get(1).getWindDirection(), CurrentWeather.get(1).getSigWaveHeight(),
                CurrentWeather.get(1).getMeanWaveDirection(), CurrentWeather.get(1).getMeanWavePeriod());
    }

    /**
     * @author jsonschema2pojo.com
     * @author Ian Weeks
     */
    @Generated("org.jsonschema2pojo")
    public class CurrentWeather
    {

        @Expose
        private String Type;
        @Expose
        private String Issued;
        @Expose
        private String TemperatureUnit;
        @Expose
        private String VisibilityUnit;
        @Expose
        private String RainfallUnit;
        @Expose
        private String WindSpeedUnit;
        @Expose
        private String WaveHeightUnit;
        @Expose
        private String WavePeriodUnit;
        @Expose
        private Double Lat;
        @Expose
        private Double Lng;
        @Expose
        private Double SeaTemperature;
        @Expose
        private String SunRise;
        @Expose
        private String SunSet;
        @Expose
        private String Date;
        @Expose
        private String Time;
        @Expose
        private String WeatherSummary;
        @Expose
        private String AirTemperature;
        @Expose
        private String Visibility;
        @Expose
        private String WindSpeed;
        @Expose
        private String GustSpeed;
        @Expose
        private String WindDirection;
        @Expose
        private String Precipitation;
        @Expose
        private String SigWaveHeight;
        @Expose
        private String MeanWaveDirection;
        @Expose
        private String MeanWavePeriod;
        @Expose
        private String IcingRisk;
        @Expose
        private String WeatherIcon;

        /**
         * @return The Type
         */
        public String getType()
        {
            return Type;
        }

        /**
         * @param Type The Type
         */
        public void setType(String Type)
        {
            this.Type = Type;
        }

        /**
         * @return The Issued
         */
        public String getIssued()
        {
            return Issued;
        }

        /**
         * @param Issued The Issued
         */
        public void setIssued(String Issued)
        {
            this.Issued = Issued;
        }

        /**
         * @return The TemperatureUnit
         */
        public String getTemperatureUnit()
        {
            return TemperatureUnit;
        }

        /**
         * @param TemperatureUnit The TemperatureUnit
         */
        public void setTemperatureUnit(String TemperatureUnit)
        {
            this.TemperatureUnit = TemperatureUnit;
        }

        /**
         * @return The VisibilityUnit
         */
        public String getVisibilityUnit()
        {
            return VisibilityUnit;
        }

        /**
         * @param VisibilityUnit The VisibilityUnit
         */
        public void setVisibilityUnit(String VisibilityUnit)
        {
            this.VisibilityUnit = VisibilityUnit;
        }

        /**
         * @return The RainfallUnit
         */
        public String getRainfallUnit()
        {
            return RainfallUnit;
        }

        /**
         * @param RainfallUnit The RainfallUnit
         */
        public void setRainfallUnit(String RainfallUnit)
        {
            this.RainfallUnit = RainfallUnit;
        }

        /**
         * @return The WindSpeedUnit
         */
        public String getWindSpeedUnit()
        {
            return WindSpeedUnit;
        }

        /**
         * @param WindSpeedUnit The WindSpeedUnit
         */
        public void setWindSpeedUnit(String WindSpeedUnit)
        {
            this.WindSpeedUnit = WindSpeedUnit;
        }

        /**
         * @return The WaveHeightUnit
         */
        public String getWaveHeightUnit()
        {
            return WaveHeightUnit;
        }

        /**
         * @param WaveHeightUnit The WaveHeightUnit
         */
        public void setWaveHeightUnit(String WaveHeightUnit)
        {
            this.WaveHeightUnit = WaveHeightUnit;
        }

        /**
         * @return The WavePeriodUnit
         */
        public String getWavePeriodUnit()
        {
            return WavePeriodUnit;
        }

        /**
         * @param WavePeriodUnit The WavePeriodUnit
         */
        public void setWavePeriodUnit(String WavePeriodUnit)
        {
            this.WavePeriodUnit = WavePeriodUnit;
        }

        /**
         * @return The Lat
         */
        public Double getLat()
        {
            return Lat;
        }

        /**
         * @param Lat The Lat
         */
        public void setLat(Double Lat)
        {
            this.Lat = Lat;
        }

        /**
         * @return The Lng
         */
        public Double getLng()
        {
            return Lng;
        }

        /**
         * @param Lng The Lng
         */
        public void setLng(Double Lng)
        {
            this.Lng = Lng;
        }

        /**
         * @return The SeaTemperature
         */
        public Double getSeaTemperature()
        {
            return SeaTemperature;
        }

        /**
         * @param SeaTemperature The SeaTemperature
         */
        public void setSeaTemperature(Double SeaTemperature)
        {
            this.SeaTemperature = SeaTemperature;
        }

        /**
         * @return The SunRise
         */
        public String getSunRise()
        {
            return SunRise;
        }

        /**
         * @param SunRise The SunRise
         */
        public void setSunRise(String SunRise)
        {
            this.SunRise = SunRise;
        }

        /**
         * @return The SunSet
         */
        public String getSunSet()
        {
            return SunSet;
        }

        /**
         * @param SunSet The SunSet
         */
        public void setSunSet(String SunSet)
        {
            this.SunSet = SunSet;
        }

        /**
         * @return The Date
         */
        public String getDate()
        {
            return Date;
        }

        /**
         * @param Date The Date
         */
        public void setDate(String Date)
        {
            this.Date = Date;
        }

        /**
         * @return The Time
         */
        public String getTime()
        {
            return Time;
        }

        /**
         * @param Time The Time
         */
        public void setTime(String Time)
        {
            this.Time = Time;
        }

        /**
         * @return The WeatherSummary
         */
        public String getWeatherSummary()
        {
            return WeatherSummary;
        }

        /**
         * @param WeatherSummary The WeatherSummary
         */
        public void setWeatherSummary(String WeatherSummary)
        {
            this.WeatherSummary = WeatherSummary;
        }

        /**
         * @return The AirTemperature
         */
        public String getAirTemperature()
        {
            return AirTemperature;
        }

        /**
         * @param AirTemperature The AirTemperature
         */
        public void setAirTemperature(String AirTemperature)
        {
            this.AirTemperature = AirTemperature;
        }

        /**
         * @return The Visibility
         */
        public String getVisibility()
        {
            return Visibility;
        }

        /**
         * @param Visibility The Visibility
         */
        public void setVisibility(String Visibility)
        {
            this.Visibility = Visibility;
        }

        /**
         * @return The WindSpeed
         */
        public String getWindSpeed()
        {
            return WindSpeed;
        }

        /**
         * @param WindSpeed The WindSpeed
         */
        public void setWindSpeed(String WindSpeed)
        {
            this.WindSpeed = WindSpeed;
        }

        /**
         * @return The GustSpeed
         */
        public String getGustSpeed()
        {
            return GustSpeed;
        }

        /**
         * @param GustSpeed The GustSpeed
         */
        public void setGustSpeed(String GustSpeed)
        {
            this.GustSpeed = GustSpeed;
        }

        /**
         * @return The WindDirection
         */
        public String getWindDirection()
        {
            return WindDirection;
        }

        /**
         * @param WindDirection The WindDirection
         */
        public void setWindDirection(String WindDirection)
        {
            this.WindDirection = WindDirection;
        }

        /**
         * @return The Precipitation
         */
        public String getPrecipitation()
        {
            return Precipitation;
        }

        /**
         * @param Precipitation The Precipitation
         */
        public void setPrecipitation(String Precipitation)
        {
            this.Precipitation = Precipitation;
        }

        /**
         * @return The SigWaveHeight
         */
        public String getSigWaveHeight()
        {
            return SigWaveHeight;
        }

        /**
         * @param SigWaveHeight The SigWaveHeight
         */
        public void setSigWaveHeight(String SigWaveHeight)
        {
            this.SigWaveHeight = SigWaveHeight;
        }

        /**
         * @return The MeanWaveDirection
         */
        public String getMeanWaveDirection()
        {
            return MeanWaveDirection;
        }

        /**
         * @param MeanWaveDirection The MeanWaveDirection
         */
        public void setMeanWaveDirection(String MeanWaveDirection)
        {
            this.MeanWaveDirection = MeanWaveDirection;
        }

        /**
         * @return The MeanWavePeriod
         */
        public String getMeanWavePeriod()
        {
            return MeanWavePeriod;
        }

        /**
         * @param MeanWavePeriod The MeanWavePeriod
         */
        public void setMeanWavePeriod(String MeanWavePeriod)
        {
            this.MeanWavePeriod = MeanWavePeriod;
        }

        /**
         * @return The IcingRisk
         */
        public String getIcingRisk()
        {
            return IcingRisk;
        }

        /**
         * @param IcingRisk The IcingRisk
         */
        public void setIcingRisk(String IcingRisk)
        {
            this.IcingRisk = IcingRisk;
        }

        /**
         * @return The WeatherIcon
         */
        public String getWeatherIcon()
        {
            return WeatherIcon;
        }

        /**
         * @param WeatherIcon The WeatherIcon
         */
        public void setWeatherIcon(String WeatherIcon)
        {
            this.WeatherIcon = WeatherIcon;
        }

        /**
         * Get a string representation of this object.
         *
         * @return A string representation of this object.
         */
        @Override
        public String toString()
        {
            return "Current:\n" +
                    "\tType = " + Type + "\n" +
                    "\t\tIssued  = " + Issued + "\n" +
                    "\t\tTemperatureUnit  = " + TemperatureUnit + "\n" +
                    "\t\tVisibilityUnit  = " + VisibilityUnit + "\n" +
                    "\t\tRainfallUnit  = " + RainfallUnit + "\n" +
                    "\t\tWindSpeedUnit  = " + WindSpeedUnit + "\n" +
                    "\t\tWaveHeightUnit  = " + WaveHeightUnit + "\n" +
                    "\t\tWavePeriodUnit  = " + WavePeriodUnit + "\n" +
                    "\t\tLat=" + Lat + "\n" +
                    "\t\tLng=" + Lng + "\n" +
                    "\t\tSeaTemperature=" + SeaTemperature + "\n" +
                    "\t\tSunRise  = " + SunRise + "\n" +
                    "\t\tSunSet  = " + SunSet + "\n" +
                    "\t\tDate  = " + Date + "\n" +
                    "\t\tTime  = " + Time + "\n" +
                    "\t\tWeatherSummary  = " + WeatherSummary + "\n" +
                    "\t\tAirTemperature  = " + AirTemperature + "\n" +
                    "\t\tVisibility  = " + Visibility + "\n" +
                    "\t\tWindSpeed  = " + WindSpeed + "\n" +
                    "\t\tGustSpeed  = " + GustSpeed + "\n" +
                    "\t\tWindDirection  = " + WindDirection + "\n" +
                    "\t\tPrecipitation  = " + Precipitation + "\n" +
                    "\t\tSigWaveHeight  = " + SigWaveHeight + "\n" +
                    "\t\tMeanWaveDirection  = " + MeanWaveDirection + "\n" +
                    "\t\tMeanWavePeriod  = " + MeanWavePeriod + "\n" +
                    "\t\tIcingRisk  = " + IcingRisk + "\n" +
                    "\t\tWeatherIcon  = " + WeatherIcon + "\n";
        }
    }
}
