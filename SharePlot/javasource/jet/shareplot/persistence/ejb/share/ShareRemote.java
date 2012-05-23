package jet.shareplot.persistence.ejb.share;

import javax.ejb.EJBException;
import javax.ejb.EJBObject;

import java.rmi.RemoteException;

/**
 * Remote interface for the bean 
 *
 * Generated by JetTools, do not edit this file directly.
 */
public interface ShareRemote extends EJBObject {
    

    /**
     * @return Long
     * @throws EJBException
     * @throws RemoteException
     */
    public Long getIdShare() throws EJBException, RemoteException;
    /**
     * @param idShare
     * @throws EJBException
     * @throws RemoteException
     */
    public void setIdShare(Long idShare) throws EJBException, RemoteException;
    

    /**
     * @return String
     * @throws EJBException
     * @throws RemoteException
     */
    public String getCode() throws EJBException, RemoteException;
    /**
     * @param code
     * @throws EJBException
     * @throws RemoteException
     */
    public void setCode(String code) throws EJBException, RemoteException;
    

    /**
     * @return java.util.Date
     * @throws EJBException
     * @throws RemoteException
     */
    public java.util.Date getDatePurchase() throws EJBException, RemoteException;
    /**
     * @param datePurchase
     * @throws EJBException
     * @throws RemoteException
     */
    public void setDatePurchase(java.util.Date datePurchase) throws EJBException, RemoteException;
    

    /**
     * @return String
     * @throws EJBException
     * @throws RemoteException
     */
    public String getDescription() throws EJBException, RemoteException;
    /**
     * @param description
     * @throws EJBException
     * @throws RemoteException
     */
    public void setDescription(String description) throws EJBException, RemoteException;
    

    /**
     * @return java.math.BigDecimal
     * @throws EJBException
     * @throws RemoteException
     */
    public java.math.BigDecimal getEntryFee() throws EJBException, RemoteException;
    /**
     * @param entryFee
     * @throws EJBException
     * @throws RemoteException
     */
    public void setEntryFee(java.math.BigDecimal entryFee) throws EJBException, RemoteException;
    

    /**
     * @return Long
     * @throws EJBException
     * @throws RemoteException
     */
    public Long getIdPortfolio() throws EJBException, RemoteException;
    /**
     * @param idPortfolio
     * @throws EJBException
     * @throws RemoteException
     */
    public void setIdPortfolio(Long idPortfolio) throws EJBException, RemoteException;
    

    /**
     * @return String
     * @throws EJBException
     * @throws RemoteException
     */
    public String getName() throws EJBException, RemoteException;
    /**
     * @param name
     * @throws EJBException
     * @throws RemoteException
     */
    public void setName(String name) throws EJBException, RemoteException;
    

    /**
     * @return java.math.BigDecimal
     * @throws EJBException
     * @throws RemoteException
     */
    public java.math.BigDecimal getPurchasePrice() throws EJBException, RemoteException;
    /**
     * @param purchasePrice
     * @throws EJBException
     * @throws RemoteException
     */
    public void setPurchasePrice(java.math.BigDecimal purchasePrice) throws EJBException, RemoteException;
    

    /**
     * @param code
     * @param datePurchase
     * @param description
     * @param entryFee
     * @param idPortfolio
     * @param name
     * @param purchasePrice
     * @throws EJBException
     * @throws RemoteException
     */
    public void update( String code, java.util.Date datePurchase, String description, java.math.BigDecimal entryFee, Long idPortfolio, String name, java.math.BigDecimal purchasePrice) throws EJBException, RemoteException;
}
