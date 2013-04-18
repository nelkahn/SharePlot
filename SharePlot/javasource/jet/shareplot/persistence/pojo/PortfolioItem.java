package jet.shareplot.persistence.pojo;

import java.io.Serializable;

import javax.annotation.Nonnull;

import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.framework.util.models.ModelHelper;
import jet.framework.util.pojo2.DispatcherModel;
import jet.framework.util.pojo2.JFDataItem;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.framework.util.pojo2.JFErrorHandlerProvider;
import jet.framework.util.pojo2.interceptor.StringLengthInterceptor;
import jet.util.logger.JETLevel;
import jet.util.logger.JETLoggerManager;
import jet.util.logger.Logger;
import jet.util.logger.LoggerJUnit;
import jet.util.models.SimpleEventModelImpl;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;
import jet.util.throwable.JETSystemError;

/**
 * Simple pojo wrapper for the Portfolio Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 *
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public class PortfolioItem implements Serializable, JFErrorHandlerProvider, JFDataItem {

    private static final long serialVersionUID = 993423458L;

    private static final String ATTRIBUTE_DISPATCHER_MODEL = "jet.shareplot.persistence.pojo.ATTRIBUTE_DISPATCHER_MODEL";

    private final Model dataModel;
    private transient Logger logger;

    private transient DispatcherModel<PortfolioItem> idPortfolioDispatcherModel;
    private transient DispatcherModel<PortfolioItem> isFakeDispatcherModel;
    private transient DispatcherModel<PortfolioItem> nameDispatcherModel;

    private transient JFErrorHandler jfErrorHandler;

    /**
     * Constructor used to create a new Portfolio Data Model.
     */
    public PortfolioItem() {
        this.dataModel = new DataModelRootNode();
        init_DataModel();
    }

    private void init_DataModel() {
        this.dataModel.setTagName("Portfolio");

        SimpleEventModelImpl model = null;

        model = new SimpleEventModelImpl("idPortfolio");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("isFake");
        String sValueIsFake = "N";
        model.setNodeValue(sValueIsFake);
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("name");
        this.dataModel.appendChild(model);
    }

    /**
     * Constructor used to edit an existing Portfolio Data Model.
     * @param model Model to use to wrap in the pojo, can not be <code>null</code>
     */
    public PortfolioItem(@Nonnull final Model model) {
        this.dataModel = model;
    }

    /**
     * Copy constructor used to clone an existing Portfolio Data Model.
     * @param portfolio PortfolioItem to use to copy in the pojo, can not be <code>null</code>
     */
    public PortfolioItem(@Nonnull final PortfolioItem portfolio) {
        this();

        setIdPortfolio(portfolio.getIdPortfolio());
        setIsFake(portfolio.getIsFake());
        setName(portfolio.getName());
    }

    private Logger getLogger() {
        if (this.logger == null) {
            // initialise the logger
            try {
                final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
                this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo");
            } catch (final JETSystemError e) {
                // probably running in junit, use junitLogger
                this.logger = LoggerJUnit.getInstance();
            }
        }
        return this.logger;
    }

    @Override
    public boolean isDirty() {
        if (get_Model() instanceof DataModelRootNode) {
            final DataModelRootNode dmrn = (DataModelRootNode) get_Model();
            return dmrn.isDirty();
        }
        getLogger().logp(JETLevel.INFO, "PortfolioItem", "isDirty", "Model is not a DataModelRootNode can not define if it is dirty.");
        return false;
    }

    /**
     * @return <code>true</code> if this portfolio is new.
     * @see JFDataItem
     */
    @Override
    public final boolean isNew() {
        return getIdPortfolio() == null;
    }

    /* (non-Javadoc)
     * @see JFErrorHandlerProvider#setJFErrorHandler(JFErrorHandler)
     */
    @Override
    public void setJFErrorHandler(final JFErrorHandler jfErrorHandler) {
        this.jfErrorHandler = jfErrorHandler;
    }

    /* (non-Javadoc)
     * @see JFErrorHandlerProvider#getJFErrorHandler()
     */
    @Override
    public JFErrorHandler getJFErrorHandler() {
        return this.jfErrorHandler;
    }

    /**
     * Get the Portfolio Data Model that is wrapped in this pojo.
     * @return Portfolio Data Model
     * @see JFDataItem
     */
    @Override
    @Nonnull
    public final Model get_Model() {
        Model model = this.dataModel;
        assert model != null;
        return model;
    }

    /**
     * Get node value of Data Model node idPortfolio.
     * This field should not be <code>null</code> in the database.
     * @return Long value of Data Model node idPortfolio
     */
    public final Long getIdPortfolio() {
        return (Long) get_IdPortfolio_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node idPortfolio.
     * This field should not be <code>null</code> in the database.
     * @param idPortfolio Long value of Data Model node idPortfolio
     */
    private final void setIdPortfolio(final Long idPortfolio) {
        get_IdPortfolio_Model().setNodeValue(idPortfolio);
    }

    /**
     * Get Model of Data Model node idPortfolio.
     * @return Model of Data Model node idPortfolio
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<PortfolioItem> get_IdPortfolio_Model() {
        if (this.idPortfolioDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "idPortfolio");
                this.idPortfolioDispatcherModel = (DispatcherModel<PortfolioItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.idPortfolioDispatcherModel == null) {
                    this.idPortfolioDispatcherModel = new DispatcherModel<PortfolioItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.idPortfolioDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("Portfolio data model does not have a child named idPortfolio. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioItem> dm = this.idPortfolioDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node isFake.
     * This field should not be <code>null</code> in the database.
     * @return String value of Data Model node isFake
     */
    public final String getIsFake() {
        return (String) get_IsFake_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node isFake.
     * This field should not be <code>null</code> in the database.
     * @param isFake String value of Data Model node isFake
     */
    public final void setIsFake(final String isFake) {
        get_IsFake_Model().setNodeValue(isFake);
    }

    /**
     * Get Model of Data Model node isFake.
     * @return Model of Data Model node isFake
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<PortfolioItem> get_IsFake_Model() {
        if (this.isFakeDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "isFake");
                this.isFakeDispatcherModel = (DispatcherModel<PortfolioItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.isFakeDispatcherModel == null) {
                    this.isFakeDispatcherModel = new DispatcherModel<PortfolioItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.isFakeDispatcherModel);
                }

                this.isFakeDispatcherModel.addInterceptor(StringLengthInterceptor.getStringLengthInterceptor(1));
            } catch (final JETException e) {
                throw new JETSystemError("Portfolio data model does not have a child named isFake. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioItem> dm = this.isFakeDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node name.
     * This field should not be <code>null</code> in the database.
     * @return String value of Data Model node name
     */
    public final String getName() {
        return (String) get_Name_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node name.
     * This field should not be <code>null</code> in the database.
     * @param name String value of Data Model node name
     */
    public final void setName(final String name) {
        get_Name_Model().setNodeValue(name);
    }

    /**
     * Get Model of Data Model node name.
     * @return Model of Data Model node name
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    public final DispatcherModel<PortfolioItem> get_Name_Model() {
        if (this.nameDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "name");
                this.nameDispatcherModel = (DispatcherModel<PortfolioItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.nameDispatcherModel == null) {
                    this.nameDispatcherModel = new DispatcherModel<PortfolioItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.nameDispatcherModel);
                }

                this.nameDispatcherModel.addInterceptor(StringLengthInterceptor.getStringLengthInterceptor(45));
            } catch (final JETException e) {
                throw new JETSystemError("Portfolio data model does not have a child named name. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioItem> dm = this.nameDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Check if any node not nullable is <code>null</code>.
     * <ul>
     * <li><b>isFake</b> can not be <code>null</code> in the database.</li>
     * <li><b>name</b> can not be <code>null</code> in the database.</li>
     * </ul>
     *
     * @return <code>true</code> if any node not nullable is <code>null</code>
     * @see JFDataItem
     */
    @Override
    public final boolean isNotNullableNull() {
        final String isFake = getIsFake();
        if (isFake == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioItem", "isNotNullableNull",
                "isFake is null but is not nullable.");
            return true;
        }
        final String name = getName();
        if (name == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioItem", "isNotNullableNull",
                "name is null but is not nullable.");
            return true;
        }
        return false;
    }

    /**
     * Check if this PK is the same as the PK from another PortfolioItem.
     *
     * @param other PortfolioItem to compare with
     * @return <code>true</code> if the pk fields from the two objects have the same values
     * @see JFDataItem
     */
    @Override
    public final boolean isPkEquals(final JFDataItem other) {
        boolean result = false;
        
        if ( getIdPortfolio() != null) {
            if (other instanceof PortfolioItem) {
                final PortfolioItem otherPortfolio = (PortfolioItem) other;
                if ( getIdPortfolio().equals(otherPortfolio.getIdPortfolio())) {
                    result = true;
                }
            }
        }
        
        return result;
    }

}
