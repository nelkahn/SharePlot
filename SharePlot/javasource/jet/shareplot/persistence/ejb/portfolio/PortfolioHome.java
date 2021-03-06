package jet.shareplot.persistence.ejb.portfolio;

import java.rmi.RemoteException;
import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.EJBHome;

import jet.framework.util.ejb.EJBParam;

/**
 * Home interface for the bean.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public interface PortfolioHome extends EJBHome {

    /**
     * <code>BEAN_NAME</code>.
     */
    static final String BEAN_NAME = "Portfolio";

    /**
     * Create a record.
     * @param idPortfolio value for the field idPortfolio
     * @param isFake value for the field isFake
     * @param name value for the field name
     * @return PortfolioRemote EJBObject implementation for the bean
     * @throws CreateException Thrown by the method to indicate a failure during the creation.
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull PortfolioRemote create(@EJBParam(name = "idPortfolio") Long idPortfolio, @EJBParam(name = "isFake") String isFake, @EJBParam(name = "name") String name) throws CreateException, RemoteException;

    /**
     * Find a record by its primary key.
     * @param pkField PRimary key object
     * @return PortfolioRemote EJBObject implementation for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull PortfolioRemote findByPrimaryKey(final java.lang.@Nullable Object pkField) throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull Collection<@NonNull PortfolioRemote> findAll() throws FinderException, RemoteException;

    /**
     * Find a collections of records.
     * @param sqlWhereClause value for the argument sqlWhereClause
     * @param sqlArguments value for the argument sqlArguments
     * @return Collection of EJBObject implementations for the bean
     * @throws FinderException The exception is used as a standard application-level exception to report a failure to find the requested EJB object(s).
     * @throws RemoteException Thrown if one of a number of communication-related exceptions occurs during the execution of the remote method call.
     */
    @NonNull Collection<@NonNull PortfolioRemote> findByPreparedSQLQuery(final @Nullable String sqlWhereClause, final Object @Nullable [] sqlArguments) throws FinderException, RemoteException;

}
