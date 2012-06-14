package jet.shareplot.persistence.finder.sharequantity;

import java.util.HashMap;
import java.util.Map;

import jet.framework.nuts.select.FinderMethod;

/**
 * Class for the findByShare FinderMethod object for the ShareQuantity component.
 *
 * SQL Query : where idShare = ? order by valueDate asc
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareQuantity_FindByShare1 implements FinderMethod {

    private static final long serialVersionUID = 1077646545L;

    Long idShare = null;

    /**
     * Set idShare argument value
     * @param idShare argument value
     */
    public void setIdShare(final Long idShare) {
        this.idShare = idShare;
    }

    @Override
    public String getFinderName() {
        return "findByShare";
    }

    @Override
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idShare", this.idShare);
        return args;
    }
}
