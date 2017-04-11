package com.jdrx.dm.baseinfo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Configuration
public class DataSourceConfig implements BeanFactoryPostProcessor, Ordered {
	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

	@Override
	public int getOrder(){
		return 1;
	}
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException{
		DruidDataSource dataSource = new DruidDataSource();
		BeanWrapper beanWrapper = new BeanWrapperImpl(dataSource);
		beanWrapper.setPropertyValues(dataSourceProperties());
		dataSource.setName(StringUtils.isEmpty(dataSource.getName()) ? "defaultDataSource" : dataSource.getName());
		beanFactory.registerSingleton("dataSource", dataSource);
	}

	public static Map<String, String> dataSourceProperties(){
		Map<String, String> configMap = new HashMap<>();
		ClassPathResource cpr = new ClassPathResource("datasource.xml");
		SAXReader reader = new SAXReader();
		Document dom = null;
		try{
			dom = reader.read(cpr.getInputStream());
		}catch(DocumentException e){
			if(logger.isErrorEnabled()){
                logger.error(String.format("datasource.xml解析异常：%s", e.getMessage()), e);
			}
		}catch(IOException e){
			if(logger.isErrorEnabled()){
                logger.error(String.format("datasource.xml读取异常：%s", e.getMessage()), e);
			}
		}
		Element root = dom.getRootElement();
		@SuppressWarnings("unchecked")
		Iterator<Element> it = root.elementIterator();
		while(it.hasNext()){
			Element e = it.next();
			Attribute name = e.attribute("name");
			Attribute value = e.attribute("value");
			if(name!=null && StringUtils.isNotEmpty(name.getValue())){
				configMap.put(name.getValue(), (value!=null ? value.getValue() : null));
			}
		}
		return configMap;
	}

}
