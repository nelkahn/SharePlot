package jet.shareplot.persistence.finder.sharequantity;

import java.util.HashMap;
import java.util.Map;

import jet.framework.nuts.select.FinderMethod;

/**
 * Class for the findByPrimaryKey FinderMethod object of the ShareQuantity component.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareQuantity_FindByPrimaryKey1 implements FinderMethod {
    Long idShareQuantity = null;

    /**
     * Set idShareQuantity argument value
     * @param idShareQuantity argument value
     */
    public void setIdShareQuantity(final Long idShareQuantity) {
        this.idShareQuantity = idShareQuantity;
    }


    @Override
    public String getFinderName() {
        return "findByPrimaryKey";
    }

    @Override
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idShareQuantity", this.idShareQuantity);
        return args;
    }
}
