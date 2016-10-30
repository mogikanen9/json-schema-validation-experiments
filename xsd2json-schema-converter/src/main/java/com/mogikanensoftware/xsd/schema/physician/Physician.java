//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.30 at 07:41:05 PM EDT 
//


package com.mogikanensoftware.xsd.schema.physician;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for physician complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="physician"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cpso" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="address" type="{http://www.example.org/physician}address"/&gt;
 *         &lt;element name="clinic" type="{http://www.example.org/physician}clinic"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "physician", propOrder = {
    "cpso",
    "address",
    "clinic"
})
public class Physician {

    @XmlElement(required = true)
    protected String cpso;
    @XmlElement(required = true)
    protected Address address;
    @XmlElement(required = true)
    protected Clinic clinic;

    /**
     * Gets the value of the cpso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpso() {
        return cpso;
    }

    /**
     * Sets the value of the cpso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpso(String value) {
        this.cpso = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the clinic property.
     * 
     * @return
     *     possible object is
     *     {@link Clinic }
     *     
     */
    public Clinic getClinic() {
        return clinic;
    }

    /**
     * Sets the value of the clinic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Clinic }
     *     
     */
    public void setClinic(Clinic value) {
        this.clinic = value;
    }

}