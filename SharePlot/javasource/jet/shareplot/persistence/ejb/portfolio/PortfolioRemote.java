package jet.shareplot.persistence.ejb.portfolio;

import javax.annotation.Nullable;
import javax.ejb.EJBException;
import javax.ejb.EJBObject;

import java.rmi.RemoteException;

/**
 * Remote interface for the bean.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public interface PortfolioRemote extends EJBObject {


    /**
     * Get the value for the field idPortfolio.
     *
     * @return Long value for the field idPortfolio
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nullable
    Long getIdPortfolio() throws EJBException, RemoteException;
    
    /**
     * Set the value for the field idPortfolio.
     *
     * @param idPortfolio value for the field idPortfolio
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    void setIdPortfolio(@Nullable final Long idPortfolio) throws EJBException, RemoteException;


    /**
     * Get the value for the field isFake.
     *
     * @return String value for the field isFake
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nullable
    String getIsFake() throws EJBException, RemoteException;
    
    /**
     * Set the value for the field isFake.
     *
     * @param isFake value for the field isFake
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    void setIsFake(@Nullable final String isFake) throws EJBException, RemoteException;


    /**
     * Get the value for the field name.
     *
     * @return String value for the field name
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @Nullable
    String getName() throws EJBException, RemoteException;
    
    /**
     * Set the value for the field name.
     *
     * @param name value for the field name
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    void setName(@Nullable final String name) throws EJBException, RemoteException;


    /**
     * Update record.
     *
     * @param isFake value for the field isFake
     * @param name value for the field name
     * @throws EJBException Thrown by the method to indicate a failure caused by a system-level error.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    void update(@Nullable final String isFake ,@Nullable final String name) throws EJBException, RemoteException;
}
