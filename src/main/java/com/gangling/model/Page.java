package com.gangling.model;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2019/1/11
 */
public class Page {
    //分页列表
    private Integer[] sliders;
    private boolean hasPrePage;
    private boolean lastPage;
    private Integer prePage;
    private boolean hasNextPage;
    private Integer nextPage;
    //总记录数
    private Integer totalCount;
    private boolean firstPage;
    //总页数
    private Integer totalPages;
    //当前页
    private Integer page;
    //每一页数量
    private Integer limit;
    private List data;

    public static Page page(PageList pageList){
        Page page=new Page();
        page.setData(pageList);
        page.setFirstPage(pageList.getPaginator().isFirstPage());
        page.setHasNextPage(pageList.getPaginator().isHasNextPage());
        page.setNextPage(pageList.getPaginator().getNextPage());
        page.setHasPrePage(pageList.getPaginator().isHasPrePage());
        page.setPrePage(pageList.getPaginator().getPrePage());
        page.setLastPage(pageList.getPaginator().isLastPage());
        page.setTotalCount(pageList.getPaginator().getTotalCount());
        page.setTotalPages(pageList.getPaginator().getTotalPages());
        page.setPage(pageList.getPaginator().getPage());
        page.setLimit(pageList.getPaginator().getLimit());
        page.setSliders(pageList.getPaginator().getSlider());
        return page;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Integer[] getSliders() {
        return sliders;
    }

    public void setSliders(Integer[] sliders) {
        this.sliders = sliders;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Page{" +
                "sliders=" + sliders +
                ", hasPrePage=" + hasPrePage +
                ", lastPage=" + lastPage +
                ", prePage=" + prePage +
                ", hasNextPage=" + hasNextPage +
                ", nextPage=" + nextPage +
                ", totalCount=" + totalCount +
                ", firstPage=" + firstPage +
                ", totalPages=" + totalPages +
                ", page=" + page +
                ", limit=" + limit +
                ", data=" + data +
                '}';
    }
}
