package jet.shareplot.persistence.ic;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import javax.ejb.EJBException;

import jet.framework.manager.datamodel.interfaces.ImutConverter;
import jet.framework.util.pojo2.validator.ValidationException;
import jet.framework.util.pojo2.validator.ValidationIssue;
import jet.shareplot.persistence.ejb.portfolio.PortfolioRemote;
import jet.shareplot.persistence.pojo.PortfolioItem;
import jet.shareplot.persistence.imut.PortfolioImut;
import jet.util.throwable.JETException;

/**
 * Portfolio ImutConverter.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class PortfolioIC implements ImutConverter<PortfolioRemote, PortfolioImut, PortfolioItem> {

    private static final long serialVersionUID = 993423458L;

    /**
     * Default constructor.
     * Nothing to do at the moment.
     */
    public PortfolioIC() {
        super();
    }

    @Override
    public @NonNull PortfolioImut readImutFromRemote(final @NonNull PortfolioRemote remote) throws JETException, ValidationException {
        PortfolioImut portfolioImut = null;

        try {
            final Long idPortfolio = remote.getIdPortfolio();
            final String isFake = remote.getIsFake();
            final String name = remote.getName();

            portfolioImut = new PortfolioImut(idPortfolio, isFake, name);

        } catch (final ValidationException e) {
            throw e;
        } catch (final EJBException e) {
            throw new JETException("EJBException while reading from PortfolioRemote.", e);
        } catch (final RemoteException e) {
            throw new JETException("RemoteException while reading from PortfolioRemote.", e);
        }

        return portfolioImut;
    }

    @Override
    public void writeImutToRemote(final @NonNull PortfolioImut imut, final @NonNull PortfolioRemote remote) throws JETException {
        try {
            // do not update pk fields
            remote.setIsFake(imut.getIsFake());
            remote.setName(imut.getName());
        } catch (final EJBException e) {
            throw new JETException("EJBException while writing to PortfolioRemote.", e);
        } catch (final RemoteException e) {
            throw new JETException("RemoteException while writing to PortfolioRemote.", e);
        }
    }

    @Override
    public @NonNull PortfolioImut readImutFromPojo(final @NonNull PortfolioItem item) throws ValidationException {
        PortfolioImut portfolioImut = null;

        if (item.isNew()) {
            final List<ValidationIssue> validationIssues = new ArrayList<>();
            validationIssues.add(new ValidationIssue("ALL_FIELDS", ValidationIssue.TYPE_NEW_POJO, null));
            throw new ValidationException("Can not create immutable object from new pojo.", validationIssues);
        }

        try {
            final Long idPortfolio = item.getIdPortfolio();
            final String isFake = item.getIsFake();
            final String name = item.getName();

            portfolioImut = new PortfolioImut(idPortfolio, isFake, name);

        } catch (final ValidationException e) {
            throw e;
        }

        return portfolioImut;
    }

    @Override
    public @NonNull PortfolioItem writeImutToPojo(final @NonNull PortfolioImut imut) {
        PortfolioItem item = new PortfolioItem();
        item.get_IdPortfolio_Model().setNodeValue(imut.getIdPortfolio());
        item.setIsFake(imut.getIsFake());
        item.setName(imut.getName());
        return item;
    }

    @Override
    public @NonNull PortfolioImut readImutFromResultSet(final @NonNull ResultSet resultSet) throws ValidationException, JETException {
        PortfolioImut portfolioImut = null;

        try {
            final Long idPortfolio = Long.valueOf(resultSet.getLong("idPortfolio"));
            final String isFake = resultSet.getString("isFake");
            final String name = resultSet.getString("name");

            portfolioImut = new PortfolioImut(idPortfolio, isFake, name);

        } catch (final ValidationException e) {
            throw e;
        } catch (final SQLException e) {
            throw new JETException("SQLException while reading from ResultSet.", e);
        }

        return portfolioImut;
    }

}
