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
import jet.shareplot.persistence.ejb.share.ShareRemote;
import jet.shareplot.persistence.pojo.ShareItem;
import jet.shareplot.persistence.imut.ShareImut;
import jet.util.throwable.JETException;

/**
 * Share ImutConverter.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public final class ShareIC implements ImutConverter<ShareRemote, ShareImut, ShareItem> {

    private static final long serialVersionUID = -1939421298L;

    /**
     * Default constructor.
     * Nothing to do at the moment.
     */
    public ShareIC() {
        super();
    }

    @Override
    public @NonNull ShareImut readImutFromRemote(final @NonNull ShareRemote remote) throws JETException, ValidationException {
        ShareImut shareImut = null;

        try {
            final Long idShare = remote.getIdShare();
            final String codeISIN = remote.getCodeISIN();
            final String codeYahoo = remote.getCodeYahoo();
            final String description = remote.getDescription();
            final String name = remote.getName();

            shareImut = new ShareImut(idShare, codeISIN, codeYahoo, description, name);

        } catch (final ValidationException e) {
            throw e;
        } catch (final EJBException e) {
            throw new JETException("EJBException while reading from ShareRemote.", e);
        } catch (final RemoteException e) {
            throw new JETException("RemoteException while reading from ShareRemote.", e);
        }

        return shareImut;
    }

    @Override
    public void writeImutToRemote(final @NonNull ShareImut imut, final @NonNull ShareRemote remote) throws JETException {
        try {
            // do not update pk fields
            remote.setCodeISIN(imut.getCodeISIN());
            remote.setCodeYahoo(imut.getCodeYahoo());
            remote.setDescription(imut.getDescription());
            remote.setName(imut.getName());
        } catch (final EJBException e) {
            throw new JETException("EJBException while writing to ShareRemote.", e);
        } catch (final RemoteException e) {
            throw new JETException("RemoteException while writing to ShareRemote.", e);
        }
    }

    @Override
    public @NonNull ShareImut readImutFromPojo(final @NonNull ShareItem item) throws ValidationException {
        ShareImut shareImut = null;

        if (item.isNew()) {
            final List<ValidationIssue> validationIssues = new ArrayList<>();
            validationIssues.add(new ValidationIssue("ALL_FIELDS", ValidationIssue.TYPE_NEW_POJO, null));
            throw new ValidationException("Can not create immutable object from new pojo.", validationIssues);
        }

        try {
            final Long idShare = item.getIdShare();
            final String codeISIN = item.getCodeISIN();
            final String codeYahoo = item.getCodeYahoo();
            final String description = item.getDescription();
            final String name = item.getName();

            shareImut = new ShareImut(idShare, codeISIN, codeYahoo, description, name);

        } catch (final ValidationException e) {
            throw e;
        }

        return shareImut;
    }

    @Override
    public @NonNull ShareItem writeImutToPojo(final @NonNull ShareImut imut) {
        ShareItem item = new ShareItem();
        item.get_IdShare_Model().setNodeValue(imut.getIdShare());
        item.setCodeISIN(imut.getCodeISIN());
        item.setCodeYahoo(imut.getCodeYahoo());
        item.setDescription(imut.getDescription());
        item.setName(imut.getName());
        return item;
    }

    @Override
    public @NonNull ShareImut readImutFromResultSet(final @NonNull ResultSet resultSet) throws ValidationException, JETException {
        ShareImut shareImut = null;

        try {
            final Long idShare = Long.valueOf(resultSet.getLong("idShare"));
            final String codeISIN = resultSet.getString("codeISIN");
            final String codeYahoo = resultSet.getString("codeYahoo");
            final String description = resultSet.getString("description");
            final String name = resultSet.getString("name");

            shareImut = new ShareImut(idShare, codeISIN, codeYahoo, description, name);

        } catch (final ValidationException e) {
            throw e;
        } catch (final SQLException e) {
            throw new JETException("SQLException while reading from ResultSet.", e);
        }

        return shareImut;
    }

}
