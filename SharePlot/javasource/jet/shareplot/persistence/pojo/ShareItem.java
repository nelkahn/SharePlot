package jet.shareplot.persistence.pojo;

import java.io.Serializable;

import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.framework.util.models.ModelHelper;
import jet.framework.util.pojo2.DispatcherModel;
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
 * Simple pojo wrapper for the Share Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 * 
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public class ShareItem implements Serializable {

    private static final long serialVersionUID = 1750601616L;

    private Model dataModel;
    private Logger logger;

    private DispatcherModel<ShareItem, Long> idShareDispatcherModel;
    private DispatcherModel<ShareItem, String> codeDispatcherModel;
    private DispatcherModel<ShareItem, java.util.Date> datePurchaseDispatcherModel;
    private DispatcherModel<ShareItem, String> descriptionDispatcherModel;
    private DispatcherModel<ShareItem, java.math.BigDecimal> entryFeeDispatcherModel;
    private DispatcherModel<ShareItem, Long> idPortfolioDispatcherModel;
    private DispatcherModel<ShareItem, String> nameDispatcherModel;
    private DispatcherModel<ShareItem, java.math.BigDecimal> purchasePriceDispatcherModel;

    /**
     * Constructor used to create a new Share Data Model
     */
    public ShareItem() {
        // initialise the logger
        try {
            final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
            this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo");
        } catch (final JETSystemError e) {
            // probably running in junit, use junitLogger
            this.logger = LoggerJUnit.getInstance();
        }
        
        init_DataModel();
    }

    private void init_DataModel() {
        this.dataModel = new DataModelRootNode();
        this.dataModel.setTagName("Share");
        
        SimpleEventModelImpl model = null;
        
        model = new SimpleEventModelImpl("idShare");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("code");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("datePurchase");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("description");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("entryFee");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("idPortfolio");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("name");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("purchasePrice");
        this.dataModel.appendChild(model);
    }
    
    /**
     * Constructor used to edit an existing Share Data Model
     * @param model Model to use to wrap in the pojo, can not be null
     * @throws IllegalArgumentException if model is null
     */
    public ShareItem(final Model model) {
        if (model == null) {
            throw new IllegalArgumentException("model argument can not be null");
        }
        // initialise the logger
        try {
            final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
            this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo");
        } catch (final JETSystemError e) {
            // probably running in junit, use junitLogger
            this.logger = LoggerJUnit.getInstance();
        }
        
        this.dataModel = model;
    }
    
    /**
     * Copy constructor used to clone an existing Share Data Model
     * @param share ShareItem to use to copy in the pojo, can not be null
     * @throws IllegalArgumentException if share is null
     */
    public ShareItem(final ShareItem share) {
        this();
        if (share == null) {
            throw new IllegalArgumentException("share argument can not be null");
        }
        
        setIdShare(share.getIdShare());
        setCode(share.getCode());
        setDatePurchase(share.getDatePurchase());
        setDescription(share.getDescription());
        setEntryFee(share.getEntryFee());
        setIdPortfolio(share.getIdPortfolio());
        setName(share.getName());
        setPurchasePrice(share.getPurchasePrice());
    }
    
    /**
     * Get the Share Data Model that is wrapped in this pojo
     * @return Share Data Model
     */
    public final Model get_Model() {
        return this.dataModel;
    }
    
    /**
     * Get node value of Data Model node idShare
     * @return Long value of Data Model node idShare
     */
    public final Long getIdShare() {
        return (Long) get_IdShare_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node idShare
     * @param idShare Long value of Data Model node idShare
     */
    private final void setIdShare(final Long idShare) {
        get_IdShare_Model().setNodeValue(idShare);
    }
    
    /**
     * Get Model of Data Model node idShare
     * @return Model of Data Model node idShare
     */
    public final DispatcherModel<ShareItem, Long> get_IdShare_Model() {
        if (this.idShareDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "idShare");
                this.idShareDispatcherModel = new DispatcherModel<ShareItem, Long>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("Share data model does not have a child named idShare. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.idShareDispatcherModel;
    }

    /**
     * Get node value of Data Model node code
     * @return String value of Data Model node code
     */
    public final String getCode() {
        return (String) get_Code_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node code
     * @param code String value of Data Model node code
     */
    public final void setCode(String code) {
        get_Code_Model().setNodeValue(code);
    }
    
    /**
     * Get Model of Data Model node code
     * @return Model of Data Model node code
     */
    public final DispatcherModel<ShareItem, String> get_Code_Model() {
        if (this.codeDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "code");
                this.codeDispatcherModel = new DispatcherModel<ShareItem, String>(this, sourceModel);

                this.codeDispatcherModel.addInterceptor(new StringLengthInterceptor<ShareItem>(45));
            } catch (final JETException e) {
                throw new JETSystemError("Share data model does not have a child named code. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.codeDispatcherModel;
    }

    /**
     * Get node value of Data Model node datePurchase
     * @return java.util.Date value of Data Model node datePurchase
     */
    public final java.util.Date getDatePurchase() {
        return (java.util.Date) get_DatePurchase_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node datePurchase
     * @param datePurchase java.util.Date value of Data Model node datePurchase
     */
    public final void setDatePurchase(java.util.Date datePurchase) {
        get_DatePurchase_Model().setNodeValue(datePurchase);
    }
    
    /**
     * Get Model of Data Model node datePurchase
     * @return Model of Data Model node datePurchase
     */
    public final DispatcherModel<ShareItem, java.util.Date> get_DatePurchase_Model() {
        if (this.datePurchaseDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "datePurchase");
                this.datePurchaseDispatcherModel = new DispatcherModel<ShareItem, java.util.Date>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("Share data model does not have a child named datePurchase. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.datePurchaseDispatcherModel;
    }

    /**
     * Get node value of Data Model node description
     * @return String value of Data Model node description
     */
    public final String getDescription() {
        return (String) get_Description_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node description
     * @param description String value of Data Model node description
     */
    public final void setDescription(String description) {
        get_Description_Model().setNodeValue(description);
    }
    
    /**
     * Get Model of Data Model node description
     * @return Model of Data Model node description
     */
    public final DispatcherModel<ShareItem, String> get_Description_Model() {
        if (this.descriptionDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "description");
                this.descriptionDispatcherModel = new DispatcherModel<ShareItem, String>(this, sourceModel);

                this.descriptionDispatcherModel.addInterceptor(new StringLengthInterceptor<ShareItem>(4000));
            } catch (final JETException e) {
                throw new JETSystemError("Share data model does not have a child named description. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.descriptionDispatcherModel;
    }

    /**
     * Get node value of Data Model node entryFee
     * @return java.math.BigDecimal value of Data Model node entryFee
     */
    public final java.math.BigDecimal getEntryFee() {
        return (java.math.BigDecimal) get_EntryFee_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node entryFee
     * @param entryFee java.math.BigDecimal value of Data Model node entryFee
     */
    public final void setEntryFee(java.math.BigDecimal entryFee) {
        get_EntryFee_Model().setNodeValue(entryFee);
    }
    
    /**
     * Get Model of Data Model node entryFee
     * @return Model of Data Model node entryFee
     */
    public final DispatcherModel<ShareItem, java.math.BigDecimal> get_EntryFee_Model() {
        if (this.entryFeeDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "entryFee");
                this.entryFeeDispatcherModel = new DispatcherModel<ShareItem, java.math.BigDecimal>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("Share data model does not have a child named entryFee. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.entryFeeDispatcherModel;
    }

    /**
     * Get node value of Data Model node idPortfolio
     * @return Long value of Data Model node idPortfolio
     */
    public final Long getIdPortfolio() {
        return (Long) get_IdPortfolio_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node idPortfolio
     * @param idPortfolio Long value of Data Model node idPortfolio
     */
    public final void setIdPortfolio(Long idPortfolio) {
        get_IdPortfolio_Model().setNodeValue(idPortfolio);
    }
    
    /**
     * Get Model of Data Model node idPortfolio
     * @return Model of Data Model node idPortfolio
     */
    public final DispatcherModel<ShareItem, Long> get_IdPortfolio_Model() {
        if (this.idPortfolioDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "idPortfolio");
                this.idPortfolioDispatcherModel = new DispatcherModel<ShareItem, Long>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("Share data model does not have a child named idPortfolio. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.idPortfolioDispatcherModel;
    }

    /**
     * Get node value of Data Model node name
     * @return String value of Data Model node name
     */
    public final String getName() {
        return (String) get_Name_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node name
     * @param name String value of Data Model node name
     */
    public final void setName(String name) {
        get_Name_Model().setNodeValue(name);
    }
    
    /**
     * Get Model of Data Model node name
     * @return Model of Data Model node name
     */
    public final DispatcherModel<ShareItem, String> get_Name_Model() {
        if (this.nameDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "name");
                this.nameDispatcherModel = new DispatcherModel<ShareItem, String>(this, sourceModel);

                this.nameDispatcherModel.addInterceptor(new StringLengthInterceptor<ShareItem>(255));
            } catch (final JETException e) {
                throw new JETSystemError("Share data model does not have a child named name. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.nameDispatcherModel;
    }

    /**
     * Get node value of Data Model node purchasePrice
     * @return java.math.BigDecimal value of Data Model node purchasePrice
     */
    public final java.math.BigDecimal getPurchasePrice() {
        return (java.math.BigDecimal) get_PurchasePrice_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node purchasePrice
     * @param purchasePrice java.math.BigDecimal value of Data Model node purchasePrice
     */
    public final void setPurchasePrice(java.math.BigDecimal purchasePrice) {
        get_PurchasePrice_Model().setNodeValue(purchasePrice);
    }
    
    /**
     * Get Model of Data Model node purchasePrice
     * @return Model of Data Model node purchasePrice
     */
    public final DispatcherModel<ShareItem, java.math.BigDecimal> get_PurchasePrice_Model() {
        if (this.purchasePriceDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "purchasePrice");
                this.purchasePriceDispatcherModel = new DispatcherModel<ShareItem, java.math.BigDecimal>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("Share data model does not have a child named purchasePrice. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.purchasePriceDispatcherModel;
    }

    /**
     * Check if any node not nullable is null
     * @return true if any node not nullable is null
     */
    public final boolean isNotNullableNull() {
        java.util.Date datePurchase = getDatePurchase();
        if (datePurchase == null) {
            this.logger.logp(JETLevel.WARNING, "ShareItem", "isNotNullableNull", 
                "datePurchase is null but is not nullable.");
            return true;
        }
        Long idPortfolio = getIdPortfolio();
        if (idPortfolio == null) {
            this.logger.logp(JETLevel.WARNING, "ShareItem", "isNotNullableNull", 
                "idPortfolio is null but is not nullable.");
            return true;
        }
        String name = getName();
        if (name == null) {
            this.logger.logp(JETLevel.WARNING, "ShareItem", "isNotNullableNull", 
                "name is null but is not nullable.");
            return true;
        }
        java.math.BigDecimal purchasePrice = getPurchasePrice();
        if (purchasePrice == null) {
            this.logger.logp(JETLevel.WARNING, "ShareItem", "isNotNullableNull", 
                "purchasePrice is null but is not nullable.");
            return true;
        }
        return false;
    }
    
}
