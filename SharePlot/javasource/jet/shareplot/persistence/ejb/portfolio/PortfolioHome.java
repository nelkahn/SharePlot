package jet.shareplot.persistence.ejb.portfolio;  

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
public interface PortfolioHome extends EJBHome {
        
    /**
     * <code>BEAN_NAME</code>
     */
    public final static String BEAN_NAME = "Portfolio";
    
    /**
     * @param idPortfolio
     * @param name
     * @param isFake
     * @return PortfolioRemote
     * @throws CreateException
     * @throws RemoteException
     */
    public PortfolioRemote create( @EJBParam(name = "idPortfolio") Long idPortfolio, @EJBParam(name = "name") String name, @EJBParam(name = "isFake") String isFake) throws CreateException, RemoteException;
        
    /**
     * @param pkField
     * @return PortfolioRemote
     * @throws FinderException
     * @throws RemoteException
     */
    public PortfolioRemote findByPrimaryKey(java.lang.Object pkField) throws FinderException, RemoteException;
    
    /**
     * @return Collection
     * @throws FinderException
     * @throws RemoteException
     */
    public Collection<PortfolioRemote> findAll() throws FinderException, RemoteException;
    
    /**
     * @param sqlWhereClause
     * @param sqlArguments
     * @return Collection
     * @throws FinderException
     * @throws RemoteException
     */
    public Collection<PortfolioRemote> findByPreparedSQLQuery(String sqlWhereClause,Object[] sqlArguments) throws FinderException, RemoteException;
    
}