package jet.shareplot.persistence.ejb.sharevalue;

import javax.annotation.Nullable;
import javax.ejb.EJBException;
import javax.ejb.EJBObject;

import java.rmi.RemoteException;

/**
 * Remote interface for the bean.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public interface ShareValueRemote extends EJBObject {


    /**
     * Get the value for the field idShareValue.
     *
     * @return Long value for the field idShareValue
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nullable
    Long getIdShareValue() throws EJBException, RemoteException;
    
    /**
     * Set the value for the field idShareValue.
     *
     * @param idShareValue value for the field idShareValue
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    void setIdShareValue(@Nullable final Long idShareValue) throws EJBException, RemoteException;


    /**
     * Get the value for the field idShare.
     *
     * @return Long value for the field idShare
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nullable
    Long getIdShare() throws EJBException, RemoteException;
    
    /**
     * Set the value for the field idShare.
     *
     * @param idShare value for the field idShare
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    void setIdShare(@Nullable final Long idShare) throws EJBException, RemoteException;


    /**
     * Get the value for the field value.
     *
     * @return java.math.BigDecimal value for the field value
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nullable
    java.math.BigDecimal getValue() throws EJBException, RemoteException;
    
    /**
     * Set the value for the field value.
     *
     * @param value value for the field value
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    void setValue(@Nullable final java.math.BigDecimal value) throws EJBException, RemoteException;


    /**
     * Get the value for the field valueDate.
     *
     * @return java.util.Date value for the field valueDate
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nullable
    java.util.Date getValueDate() throws EJBException, RemoteException;
    
    /**
     * Set the value for the field valueDate.
     *
     * @param valueDate value for the field valueDate
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    void setValueDate(@Nullable final java.util.Date valueDate) throws EJBException, RemoteException;


    /**
     * Update record.
     *
     * @param idShare value for the field idShare
     * @param value value for the field value
     * @param valueDate value for the field valueDate
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    void update(@Nullable final Long idShare ,@Nullable final java.math.BigDecimal value ,@Nullable final java.util.Date valueDate) throws EJBException, RemoteException;
}
