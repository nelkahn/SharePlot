package jet.shareplot.persistence.ejb.share;  

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.EJBHome;

import jet.framework.util.ejb.EJBParam;

/**
 * Home interface for the bean 
 *
 * Generated by JetTools, do not edit this file directly.
 */
public interface ShareHome extends EJBHome {
        
    /**
     * <code>BEAN_NAME</code>
     */
    public final static String BEAN_NAME = "Share";
    
    /**
     * @param idShare
     * @param name
     * @param description
     * @param code
     * @param datePurchase
     * @param purchasePrice
     * @param entryFee
     * @return ShareRemote
     * @throws CreateException
     * @throws RemoteException
     */
    public ShareRemote create( @EJBParam(name = "idShare") Long idShare, @EJBParam(name = "name") String name, @EJBParam(name = "description") String description, @EJBParam(name = "code") String code, @EJBParam(name = "datePurchase") java.util.Date datePurchase, @EJBParam(name = "purchasePrice") java.math.BigDecimal purchasePrice, @EJBParam(name = "entryFee") java.math.BigDecimal entryFee) throws CreateException, RemoteException;
        
    /**
     * @param pkField
     * @return ShareRemote
     * @throws FinderException
     * @throws RemoteException
     */
    public ShareRemote findByPrimaryKey(java.lang.Object pkField) throws FinderException, RemoteException;
    
    /**
     * @return Collection
     * @throws FinderException
     * @throws RemoteException
     */
    public Collection<ShareRemote> findAll() throws FinderException, RemoteException;
    
    /**
     * @param sqlWhereClause
     * @param sqlArguments
     * @return Collection
     * @throws FinderException
     * @throws RemoteException
     */
    public Collection<ShareRemote> findByPreparedSQLQuery(String sqlWhereClause,Object[] sqlArguments) throws FinderException, RemoteException;
    
}