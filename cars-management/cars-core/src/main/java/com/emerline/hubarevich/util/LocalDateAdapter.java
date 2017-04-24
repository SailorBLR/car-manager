package com.emerline.hubarevich.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anton Hubarevich on 24.04.2017.
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String dateString) throws Exception {
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return DateTimeFormatter.ISO_DATE.format(localDate);
    }
}