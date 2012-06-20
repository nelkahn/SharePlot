package jet.shareplot.persistence.finder.sharevalue;

import java.util.HashMap;
import java.util.Map;

import jet.framework.nuts.select.FinderMethod;

/**
 * Class for the findByPrimaryKey FinderMethod object of the ShareValue component.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class ShareValue_FindByPrimaryKey1 implements FinderMethod {

    private static final long serialVersionUID = 1303211696L;

    Long idShareValue = null;

    /**
     * Set idShareValue argument value
     * @param idShareValue argument value
     */
    public void setIdShareValue(final Long idShareValue) {
        this.idShareValue = idShareValue;
    }


    @Override
    public String getFinderName() {
        return "findByPrimaryKey";
    }

    @Override
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("idShareValue", this.idShareValue);
        return args;
    }
}
