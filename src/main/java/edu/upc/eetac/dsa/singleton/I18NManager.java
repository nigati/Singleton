package edu.upc.eetac.dsa.singleton;

import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.ResourceBundle;

    public class I18NManager {
        final static Logger log = Logger.getLogger(I18NManager.class.getName());

        private static I18NManager instance;

        private HashMap<String, ResourceBundle> languages;

        //Let's declare its private constructor
        private I18NManager(){
            languages = new HashMap<String, ResourceBundle>();
        }

        public static I18NManager getInstance(){
            if(instance == null) instance = new I18NManager();
            return instance;
        }

        public void clear() {

        }
        public String getText (String filename, String key) throws Exception{
            ResourceBundle rbundle = languages.get(filename);
            log.info("language:"+filename+"key:"+key);
            if (rbundle ==null ) {
                log.info ("I'm going to the file system");
                rbundle = ResourceBundle.getBundle(filename);
                log.info ("The bundle is being added to cache");
                languages.put(filename, rbundle);

            }
            else {
                log.warn("Bundle used in cache");
            }
            String text = rbundle.getString(key);
            log.info(text);
            return text;
        }
    }
