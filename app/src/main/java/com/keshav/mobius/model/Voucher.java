package com.keshav.mobius.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Voucher {
    public String id;
    public Date valid_from;
    public Date valid_until;
    public boolean is_active;
    public boolean is_deleted;
    public Tags tags;
    public Date created_at;
    public Date last_updated_at;
    public String code;
    public String bonus_image_front;
    public String bonus_image_back;
    public int user_redeem_limit;
    public int user_limit;
    public String tab_type;
    public String ribbon_msg;
    public boolean is_bonus_booster_enabled;
    public int wager_bonus_expiry;
    public int wager_to_release_ratio_numerator;
    public int wager_to_release_ratio_denominator;
    public ArrayList<Slab> slabs;
    public String user_segmentation_type;
    public List<Integer> eligibility_user_levels;
    public List<String> eligibility_user_segments;
    public List<Integer> visibility_user_levels;
    public List<String> visibility_user_segments;
    public int days_since_last_purchase_min;
    public String _cls;
    public String campaign;
    public String bonus_booster;

    private class Tags {
    }

    public Voucher(String id, Date valid_from, Date valid_until, boolean is_active, boolean is_deleted, Tags tags, Date created_at, Date last_updated_at, String code, String bonus_image_front, String bonus_image_back, int user_redeem_limit, int user_limit, String tab_type, String ribbon_msg, boolean is_bonus_booster_enabled, int wager_bonus_expiry, int wager_to_release_ratio_numerator, int wager_to_release_ratio_denominator, ArrayList<Slab> slabs, String user_segmentation_type, List<Integer> eligibility_user_levels, List<String> eligibility_user_segments, List<Integer> visibility_user_levels, List<String> visibility_user_segments, int days_since_last_purchase_min, String _cls, String campaign, String bonus_booster) {
        this.id = id;
        this.valid_from = valid_from;
        this.valid_until = valid_until;
        this.is_active = is_active;
        this.is_deleted = is_deleted;
        this.tags = tags;
        this.created_at = created_at;
        this.last_updated_at = last_updated_at;
        this.code = code;
        this.bonus_image_front = bonus_image_front;
        this.bonus_image_back = bonus_image_back;
        this.user_redeem_limit = user_redeem_limit;
        this.user_limit = user_limit;
        this.tab_type = tab_type;
        this.ribbon_msg = ribbon_msg;
        this.is_bonus_booster_enabled = is_bonus_booster_enabled;
        this.wager_bonus_expiry = wager_bonus_expiry;
        this.wager_to_release_ratio_numerator = wager_to_release_ratio_numerator;
        this.wager_to_release_ratio_denominator = wager_to_release_ratio_denominator;
        this.slabs = slabs;
        this.user_segmentation_type = user_segmentation_type;
        this.eligibility_user_levels = eligibility_user_levels;
        this.eligibility_user_segments = eligibility_user_segments;
        this.visibility_user_levels = visibility_user_levels;
        this.visibility_user_segments = visibility_user_segments;
        this.days_since_last_purchase_min = days_since_last_purchase_min;
        this._cls = _cls;
        this.campaign = campaign;
        this.bonus_booster = bonus_booster;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getValid_from() {
        return valid_from;
    }

    public void setValid_from(Date valid_from) {
        this.valid_from = valid_from;
    }

    public Date getValid_until() {
        return valid_until;
    }

    public void setValid_until(Date valid_until) {
        this.valid_until = valid_until;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getLast_updated_at() {
        return last_updated_at;
    }

    public void setLast_updated_at(Date last_updated_at) {
        this.last_updated_at = last_updated_at;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBonus_image_front() {
        return bonus_image_front;
    }

    public void setBonus_image_front(String bonus_image_front) {
        this.bonus_image_front = bonus_image_front;
    }

    public String getBonus_image_back() {
        return bonus_image_back;
    }

    public void setBonus_image_back(String bonus_image_back) {
        this.bonus_image_back = bonus_image_back;
    }

    public int getUser_redeem_limit() {
        return user_redeem_limit;
    }

    public void setUser_redeem_limit(int user_redeem_limit) {
        this.user_redeem_limit = user_redeem_limit;
    }

    public int getUser_limit() {
        return user_limit;
    }

    public void setUser_limit(int user_limit) {
        this.user_limit = user_limit;
    }

    public String getTab_type() {
        return tab_type;
    }

    public void setTab_type(String tab_type) {
        this.tab_type = tab_type;
    }

    public String getRibbon_msg() {
        return ribbon_msg;
    }

    public void setRibbon_msg(String ribbon_msg) {
        this.ribbon_msg = ribbon_msg;
    }

    public boolean isIs_bonus_booster_enabled() {
        return is_bonus_booster_enabled;
    }

    public void setIs_bonus_booster_enabled(boolean is_bonus_booster_enabled) {
        this.is_bonus_booster_enabled = is_bonus_booster_enabled;
    }

    public int getWager_bonus_expiry() {
        return wager_bonus_expiry;
    }

    public void setWager_bonus_expiry(int wager_bonus_expiry) {
        this.wager_bonus_expiry = wager_bonus_expiry;
    }

    public int getWager_to_release_ratio_numerator() {
        return wager_to_release_ratio_numerator;
    }

    public void setWager_to_release_ratio_numerator(int wager_to_release_ratio_numerator) {
        this.wager_to_release_ratio_numerator = wager_to_release_ratio_numerator;
    }

    public int getWager_to_release_ratio_denominator() {
        return wager_to_release_ratio_denominator;
    }

    public void setWager_to_release_ratio_denominator(int wager_to_release_ratio_denominator) {
        this.wager_to_release_ratio_denominator = wager_to_release_ratio_denominator;
    }

    public ArrayList<Slab> getSlabs() {
        return slabs;
    }

    public void setSlabs(ArrayList<Slab> slabs) {
        this.slabs = slabs;
    }

    public String getUser_segmentation_type() {
        return user_segmentation_type;
    }

    public void setUser_segmentation_type(String user_segmentation_type) {
        this.user_segmentation_type = user_segmentation_type;
    }

    public List<Integer> getEligibility_user_levels() {
        return eligibility_user_levels;
    }

    public void setEligibility_user_levels(List<Integer> eligibility_user_levels) {
        this.eligibility_user_levels = eligibility_user_levels;
    }

    public List<String> getEligibility_user_segments() {
        return eligibility_user_segments;
    }

    public void setEligibility_user_segments(List<String> eligibility_user_segments) {
        this.eligibility_user_segments = eligibility_user_segments;
    }

    public List<Integer> getVisibility_user_levels() {
        return visibility_user_levels;
    }

    public void setVisibility_user_levels(List<Integer> visibility_user_levels) {
        this.visibility_user_levels = visibility_user_levels;
    }

    public List<String> getVisibility_user_segments() {
        return visibility_user_segments;
    }

    public void setVisibility_user_segments(List<String> visibility_user_segments) {
        this.visibility_user_segments = visibility_user_segments;
    }

    public int getDays_since_last_purchase_min() {
        return days_since_last_purchase_min;
    }

    public void setDays_since_last_purchase_min(int days_since_last_purchase_min) {
        this.days_since_last_purchase_min = days_since_last_purchase_min;
    }

    public String get_cls() {
        return _cls;
    }

    public void set_cls(String _cls) {
        this._cls = _cls;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getBonus_booster() {
        return bonus_booster;
    }

    public void setBonus_booster(String bonus_booster) {
        this.bonus_booster = bonus_booster;
    }
}
