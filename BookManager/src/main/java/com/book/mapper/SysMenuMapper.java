
package com.book.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import com.mysql.jdbc.StringUtils;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月23日 下午11:06:04 

* 类说明 

*/
public interface SysMenuMapper {
	/**
	 * 通过父id 查询子节点菜单
	 * @param id
	 * @return
	 */
	@Select("select m.id,m.menu_name text,m.iconCls,m.state,m.href from sys_menu m where m.parent_id =#{arg0} order by m.order_by")
	public List<Map<String,Object>> getSysMenuByParentId(String id);
	/**
	 * 分页查询所有的菜单信息
	 * @param page 当前页码
	 * @param rows 每页显示条数
	 * @return 菜单信息 
	 */
	@Select("select * from sys_menu m order by m.id LIMIT #{arg0},#{arg1}")
	public List<Map<String,Object>> getAllSysMenuByPage(int startIndex,int rows);
	/**
	 * 获得所有的数据条数
	 * @return
	 */
	@Select("select COUNT(m.id) from sys_menu m")
	public int getAllSysMenuCount();
	/**
	 * 插入一条菜单信息，并返回主键
	 * @return
	 */
	@Insert("insert into sys_menu (id,menu_name,menu_code,state,iconCls,parent_id,href,ORDER_BY) values(UUID(),#{M.menu_name},#{M.menu_code},#{M.state},#{M.iconCls},#{M.parent_id},#{M.href},#{M.order_by})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="M.id")
	public int insertSysMenu(@Param("M") Map<String,Object> sysMenu);
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@Delete("DELETE from sys_menu where id in(${ids})")
	public int deleteSysMenu(@Param(value="ids") String ids);
	/**
	 * 通过id得到一条数据
	 * @param id
	 * @return
	 */
	@Select("select * from sys_menu m where m.id = #{arg0}")
	public Map<String,Object> getSysMenuById(String id);
	/**
	 * 修改菜单信息，并返回主键
	 * @return
	 */
	@Update("update sys_menu as m set m.menu_name=#{menu_name},m.href=#{href},m.iconCls=#{iconCls},m.menu_code=#{menu_code},m.order_by=#{order_by},m.parent_id=#{parent_id},m.state=#{state}  where m.id = #{id}")
	public int updateSysMenu(Map<String,Object> sysMenu);
	
	@SelectProvider(type=SysMenuMapperProvider.class,method="getSysMenuByNotId")
	public List<Map<String,Object>> getSysMenuByNotId(String id);
	/**
	 * 内部类用于生成动态sql
	 * @author lilei 
	 *
	 */
	class SysMenuMapperProvider{
		/**
		 * 查询 排除某一id以外的所有菜单信息
		 * @param id
		 * @return
		 */
		public String getSysMenuByNotId(final String id){
			return new SQL(){{
				SELECT("id,menu_name");
				FROM("sys_menu");
				if(id!=null){
					WHERE("id <> #{arg0}");
				}
				ORDER_BY("id");
			}}.toString();
		}
	}
}
