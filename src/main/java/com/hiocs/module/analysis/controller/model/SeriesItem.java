/**
 * 
 */
package com.hiocs.module.analysis.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qqwer
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeriesItem {
	private String name;
	private Object[] data;

}
