package com.howtodoinjava.demo.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*@JacksonXmlRootElement(localName = "record")*/
@XmlRootElement(name = "record")
@XmlAccessorType(XmlAccessType.FIELD)
public class Record {

  private Long id;

 /* @JacksonXmlElementWrapper(localName = "items")
  @JacksonXmlProperty(localName = "item")*/
  @XmlElementWrapper(name = "items")
  @XmlElement(name = "item")
  List<Item> items;
}
