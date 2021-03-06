package jet.shareplot.persistence.factory;

import java.io.Serializable;

import org.eclipse.jdt.annotation.NonNull;

import jet.framework.util.models.ModelHelper;
import jet.shareplot.persistence.pojo.ShareQuantityItem;
import jet.util.logger.JETLevel;
import jet.util.logger.JETLoggerManager;
import jet.util.logger.Logger;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

/**
 * Simple pojo factory for the ShareQuantity Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 *
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public final class ShareQuantityFactory implements Serializable {

    private static final long serialVersionUID = 1612007130L;
    private static volatile Logger logger;

    private ShareQuantityFactory() {
        // Singleton, add a private constructor to prevent instantiation
    }

    /**
     * Get a ShareQuantityItem initialized from a Model that has the same structure but contains
     * only String node values. These will be converted to the proper DataModel node value
     * types.
     *
     * @param untypedModel Model with String node values
     * @return ShareQuantityItem
     */
    public static @NonNull ShareQuantityItem getFromUntypedModel(final Model untypedModel) {
        final ShareQuantityItem item = new ShareQuantityItem();

        String sValue = null;

        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShareQuantity");
            if (sValue != null) {
                item.get_IdShareQuantity_Model().setNodeValue(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "changeFee");
            if (sValue != null) {
                item.setChangeFee(new java.math.BigDecimal(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "changeQuantity");
            if (sValue != null) {
                item.setChangeQuantity(new java.math.BigDecimal(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "changeType");
            if (sValue == null) {
                sValue = " ";
            }
            item.setChangeType(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "changeValue");
            if (sValue != null) {
                item.setChangeValue(new java.math.BigDecimal(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "description");
            item.setDescription(sValue);
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idPortfolio");
            if (sValue != null) {
                item.setIdPortfolio(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShare");
            if (sValue != null) {
                item.setIdShare(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "totalQuantity");
            if (sValue != null) {
                item.setTotalQuantity(new java.math.BigDecimal(sValue));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "valueDate");
            if (sValue != null) {
                final Long timestamp = Long.valueOf(sValue);
                item.setValueDate(new java.util.Date(timestamp.longValue()));
            }
        } catch (final JETException e) {
            getLogger().logp(JETLevel.INFO, "ShareQuantityItem", "getFromUntypedModel", e.getMessage(), e);
        }
        return item;
    }

    /**
     * Get logger.
     *
     * @return Logger
     * @see "http://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java"
     */
    private static @NonNull Logger getLogger() {
        Logger result = logger;
        if (result == null) {
            synchronized (ShareQuantityFactory.class) {
                result = logger;
                if (result == null) {
                    result = logger = JETLoggerManager.getJETLoggerManager().getLogger("jet.shareplot.persistence.factory");
                }
            }
        }
        return result;
    }
}
