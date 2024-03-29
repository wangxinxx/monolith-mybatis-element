package com.mycompany.myapp.service.criteria;

import com.diboot.core.binding.query.BindQuery;
import com.mycompany.myapp.domain.ResourceCategory;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.mycompany.myapp.domain.UploadImage} entity. This class is used
 * in {@link com.mycompany.myapp.web.rest.UploadImageResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /upload-images?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UploadImageCriteria implements Serializable, Criteria {

    @BindQuery(ignore = true)
    private String jhiCommonSearchKeywords;

    @BindQuery(ignore = true)
    private Boolean useOr = false;

    @BindQuery(ignore = true)
    private UploadImageCriteria and;

    @BindQuery(ignore = true)
    private UploadImageCriteria or;

    private static final long serialVersionUID = 1L;

    @BindQuery(column = "self.id")
    private LongFilter id;

    @BindQuery(column = "self.url")
    private StringFilter url;

    @BindQuery(column = "self.full_name")
    private StringFilter fullName;

    @BindQuery(column = "self.name")
    private StringFilter name;

    @BindQuery(column = "self.ext")
    private StringFilter ext;

    @BindQuery(column = "self.type")
    private StringFilter type;

    @BindQuery(column = "self.path")
    private StringFilter path;

    @BindQuery(column = "self.folder")
    private StringFilter folder;

    @BindQuery(column = "self.owner_entity_name")
    private StringFilter ownerEntityName;

    @BindQuery(column = "self.owner_entity_id")
    private LongFilter ownerEntityId;

    @BindQuery(column = "self.business_title")
    private StringFilter businessTitle;

    @BindQuery(column = "self.business_desc")
    private StringFilter businessDesc;

    @BindQuery(column = "self.business_status")
    private StringFilter businessStatus;

    @BindQuery(column = "self.create_at")
    private ZonedDateTimeFilter createAt;

    @BindQuery(column = "self.file_size")
    private LongFilter fileSize;

    @BindQuery(column = "self.smart_url")
    private StringFilter smartUrl;

    @BindQuery(column = "self.medium_url")
    private StringFilter mediumUrl;

    @BindQuery(column = "self.reference_count")
    private LongFilter referenceCount;

    @BindQuery(column = "self.created_by")
    private LongFilter createdBy;

    @BindQuery(column = "self.created_date")
    private InstantFilter createdDate;

    @BindQuery(column = "self.last_modified_by")
    private LongFilter lastModifiedBy;

    @BindQuery(column = "self.last_modified_date")
    private InstantFilter lastModifiedDate;

    @BindQuery(column = "self.category_id")
    private LongFilter categoryId;

    @BindQuery(entity = ResourceCategory.class, column = "title", condition = "this.category_id=id")
    private StringFilter categoryTitle;

    @BindQuery(ignore = true)
    private Boolean distinct;

    public UploadImageCriteria() {}

    public UploadImageCriteria(UploadImageCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.url = other.url == null ? null : other.url.copy();
        this.fullName = other.fullName == null ? null : other.fullName.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.ext = other.ext == null ? null : other.ext.copy();
        this.type = other.type == null ? null : other.type.copy();
        this.path = other.path == null ? null : other.path.copy();
        this.folder = other.folder == null ? null : other.folder.copy();
        this.ownerEntityName = other.ownerEntityName == null ? null : other.ownerEntityName.copy();
        this.ownerEntityId = other.ownerEntityId == null ? null : other.ownerEntityId.copy();
        this.businessTitle = other.businessTitle == null ? null : other.businessTitle.copy();
        this.businessDesc = other.businessDesc == null ? null : other.businessDesc.copy();
        this.businessStatus = other.businessStatus == null ? null : other.businessStatus.copy();
        this.createAt = other.createAt == null ? null : other.createAt.copy();
        this.fileSize = other.fileSize == null ? null : other.fileSize.copy();
        this.smartUrl = other.smartUrl == null ? null : other.smartUrl.copy();
        this.mediumUrl = other.mediumUrl == null ? null : other.mediumUrl.copy();
        this.referenceCount = other.referenceCount == null ? null : other.referenceCount.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdDate = other.createdDate == null ? null : other.createdDate.copy();
        this.lastModifiedBy = other.lastModifiedBy == null ? null : other.lastModifiedBy.copy();
        this.lastModifiedDate = other.lastModifiedDate == null ? null : other.lastModifiedDate.copy();
        this.categoryId = other.categoryId == null ? null : other.categoryId.copy();
        this.categoryTitle = other.categoryTitle == null ? null : other.categoryTitle.copy();
        this.distinct = other.distinct;
    }

    @Override
    public UploadImageCriteria copy() {
        return new UploadImageCriteria(this);
    }

    public void setAnd(UploadImageCriteria and) {
        this.and = and;
    }

    public UploadImageCriteria getAnd() {
        return and;
    }

    public UploadImageCriteria and() {
        if (and == null) {
            and = new UploadImageCriteria();
        }
        return and;
    }

    public void setOr(UploadImageCriteria or) {
        this.or = or;
    }

    public UploadImageCriteria getOr() {
        return or;
    }

    public UploadImageCriteria or() {
        if (or == null) {
            or = new UploadImageCriteria();
        }
        return or;
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getUrl() {
        return url;
    }

    public StringFilter url() {
        if (url == null) {
            url = new StringFilter();
        }
        return url;
    }

    public void setUrl(StringFilter url) {
        this.url = url;
    }

    public StringFilter getFullName() {
        return fullName;
    }

    public StringFilter fullName() {
        if (fullName == null) {
            fullName = new StringFilter();
        }
        return fullName;
    }

    public void setFullName(StringFilter fullName) {
        this.fullName = fullName;
    }

    public StringFilter getName() {
        return name;
    }

    public StringFilter name() {
        if (name == null) {
            name = new StringFilter();
        }
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getExt() {
        return ext;
    }

    public StringFilter ext() {
        if (ext == null) {
            ext = new StringFilter();
        }
        return ext;
    }

    public void setExt(StringFilter ext) {
        this.ext = ext;
    }

    public StringFilter getType() {
        return type;
    }

    public StringFilter type() {
        if (type == null) {
            type = new StringFilter();
        }
        return type;
    }

    public void setType(StringFilter type) {
        this.type = type;
    }

    public StringFilter getPath() {
        return path;
    }

    public StringFilter path() {
        if (path == null) {
            path = new StringFilter();
        }
        return path;
    }

    public void setPath(StringFilter path) {
        this.path = path;
    }

    public StringFilter getFolder() {
        return folder;
    }

    public StringFilter folder() {
        if (folder == null) {
            folder = new StringFilter();
        }
        return folder;
    }

    public void setFolder(StringFilter folder) {
        this.folder = folder;
    }

    public StringFilter getOwnerEntityName() {
        return ownerEntityName;
    }

    public StringFilter ownerEntityName() {
        if (ownerEntityName == null) {
            ownerEntityName = new StringFilter();
        }
        return ownerEntityName;
    }

    public void setOwnerEntityName(StringFilter ownerEntityName) {
        this.ownerEntityName = ownerEntityName;
    }

    public LongFilter getOwnerEntityId() {
        return ownerEntityId;
    }

    public LongFilter ownerEntityId() {
        if (ownerEntityId == null) {
            ownerEntityId = new LongFilter();
        }
        return ownerEntityId;
    }

    public void setOwnerEntityId(LongFilter ownerEntityId) {
        this.ownerEntityId = ownerEntityId;
    }

    public StringFilter getBusinessTitle() {
        return businessTitle;
    }

    public StringFilter businessTitle() {
        if (businessTitle == null) {
            businessTitle = new StringFilter();
        }
        return businessTitle;
    }

    public void setBusinessTitle(StringFilter businessTitle) {
        this.businessTitle = businessTitle;
    }

    public StringFilter getBusinessDesc() {
        return businessDesc;
    }

    public StringFilter businessDesc() {
        if (businessDesc == null) {
            businessDesc = new StringFilter();
        }
        return businessDesc;
    }

    public void setBusinessDesc(StringFilter businessDesc) {
        this.businessDesc = businessDesc;
    }

    public StringFilter getBusinessStatus() {
        return businessStatus;
    }

    public StringFilter businessStatus() {
        if (businessStatus == null) {
            businessStatus = new StringFilter();
        }
        return businessStatus;
    }

    public void setBusinessStatus(StringFilter businessStatus) {
        this.businessStatus = businessStatus;
    }

    public ZonedDateTimeFilter getCreateAt() {
        return createAt;
    }

    public ZonedDateTimeFilter createAt() {
        if (createAt == null) {
            createAt = new ZonedDateTimeFilter();
        }
        return createAt;
    }

    public void setCreateAt(ZonedDateTimeFilter createAt) {
        this.createAt = createAt;
    }

    public LongFilter getFileSize() {
        return fileSize;
    }

    public LongFilter fileSize() {
        if (fileSize == null) {
            fileSize = new LongFilter();
        }
        return fileSize;
    }

    public void setFileSize(LongFilter fileSize) {
        this.fileSize = fileSize;
    }

    public StringFilter getSmartUrl() {
        return smartUrl;
    }

    public StringFilter smartUrl() {
        if (smartUrl == null) {
            smartUrl = new StringFilter();
        }
        return smartUrl;
    }

    public void setSmartUrl(StringFilter smartUrl) {
        this.smartUrl = smartUrl;
    }

    public StringFilter getMediumUrl() {
        return mediumUrl;
    }

    public StringFilter mediumUrl() {
        if (mediumUrl == null) {
            mediumUrl = new StringFilter();
        }
        return mediumUrl;
    }

    public void setMediumUrl(StringFilter mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public LongFilter getReferenceCount() {
        return referenceCount;
    }

    public LongFilter referenceCount() {
        if (referenceCount == null) {
            referenceCount = new LongFilter();
        }
        return referenceCount;
    }

    public void setReferenceCount(LongFilter referenceCount) {
        this.referenceCount = referenceCount;
    }

    public LongFilter getCreatedBy() {
        return createdBy;
    }

    public LongFilter createdBy() {
        if (createdBy == null) {
            createdBy = new LongFilter();
        }
        return createdBy;
    }

    public void setCreatedBy(LongFilter createdBy) {
        this.createdBy = createdBy;
    }

    public InstantFilter getCreatedDate() {
        return createdDate;
    }

    public InstantFilter createdDate() {
        if (createdDate == null) {
            createdDate = new InstantFilter();
        }
        return createdDate;
    }

    public void setCreatedDate(InstantFilter createdDate) {
        this.createdDate = createdDate;
    }

    public LongFilter getLastModifiedBy() {
        return lastModifiedBy;
    }

    public LongFilter lastModifiedBy() {
        if (lastModifiedBy == null) {
            lastModifiedBy = new LongFilter();
        }
        return lastModifiedBy;
    }

    public void setLastModifiedBy(LongFilter lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public InstantFilter getLastModifiedDate() {
        return lastModifiedDate;
    }

    public InstantFilter lastModifiedDate() {
        if (lastModifiedDate == null) {
            lastModifiedDate = new InstantFilter();
        }
        return lastModifiedDate;
    }

    public void setLastModifiedDate(InstantFilter lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public LongFilter getCategoryId() {
        return categoryId;
    }

    public LongFilter categoryId() {
        if (categoryId == null) {
            categoryId = new LongFilter();
        }
        return categoryId;
    }

    public void setCategoryId(LongFilter categoryId) {
        this.categoryId = categoryId;
    }

    public StringFilter getCategoryTitle() {
        return categoryTitle;
    }

    public StringFilter categoryTitle() {
        if (categoryTitle == null) {
            categoryTitle = new StringFilter();
        }
        return categoryTitle;
    }

    public void setCategoryTitle(StringFilter categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getJhiCommonSearchKeywords() {
        return jhiCommonSearchKeywords;
    }

    public void setJhiCommonSearchKeywords(String jhiCommonSearchKeywords) {
        this.jhiCommonSearchKeywords = jhiCommonSearchKeywords;
    }

    public Boolean getUseOr() {
        return useOr;
    }

    public void setUseOr(Boolean useOr) {
        this.useOr = useOr;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UploadImageCriteria that = (UploadImageCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(url, that.url) &&
            Objects.equals(fullName, that.fullName) &&
            Objects.equals(name, that.name) &&
            Objects.equals(ext, that.ext) &&
            Objects.equals(type, that.type) &&
            Objects.equals(path, that.path) &&
            Objects.equals(folder, that.folder) &&
            Objects.equals(ownerEntityName, that.ownerEntityName) &&
            Objects.equals(ownerEntityId, that.ownerEntityId) &&
            Objects.equals(businessTitle, that.businessTitle) &&
            Objects.equals(businessDesc, that.businessDesc) &&
            Objects.equals(businessStatus, that.businessStatus) &&
            Objects.equals(createAt, that.createAt) &&
            Objects.equals(fileSize, that.fileSize) &&
            Objects.equals(smartUrl, that.smartUrl) &&
            Objects.equals(mediumUrl, that.mediumUrl) &&
            Objects.equals(referenceCount, that.referenceCount) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdDate, that.createdDate) &&
            Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
            Objects.equals(lastModifiedDate, that.lastModifiedDate) &&
            Objects.equals(categoryId, that.categoryId) &&
            Objects.equals(categoryTitle, that.categoryTitle) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            url,
            fullName,
            name,
            ext,
            type,
            path,
            folder,
            ownerEntityName,
            ownerEntityId,
            businessTitle,
            businessDesc,
            businessStatus,
            createAt,
            fileSize,
            smartUrl,
            mediumUrl,
            referenceCount,
            createdBy,
            createdDate,
            lastModifiedBy,
            lastModifiedDate,
            categoryId,
            categoryTitle,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UploadImageCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (url != null ? "url=" + url + ", " : "") +
            (fullName != null ? "fullName=" + fullName + ", " : "") +
            (name != null ? "name=" + name + ", " : "") +
            (ext != null ? "ext=" + ext + ", " : "") +
            (type != null ? "type=" + type + ", " : "") +
            (path != null ? "path=" + path + ", " : "") +
            (folder != null ? "folder=" + folder + ", " : "") +
            (ownerEntityName != null ? "ownerEntityName=" + ownerEntityName + ", " : "") +
            (ownerEntityId != null ? "ownerEntityId=" + ownerEntityId + ", " : "") +
            (businessTitle != null ? "businessTitle=" + businessTitle + ", " : "") +
            (businessDesc != null ? "businessDesc=" + businessDesc + ", " : "") +
            (businessStatus != null ? "businessStatus=" + businessStatus + ", " : "") +
            (createAt != null ? "createAt=" + createAt + ", " : "") +
            (fileSize != null ? "fileSize=" + fileSize + ", " : "") +
            (smartUrl != null ? "smartUrl=" + smartUrl + ", " : "") +
            (mediumUrl != null ? "mediumUrl=" + mediumUrl + ", " : "") +
            (referenceCount != null ? "referenceCount=" + referenceCount + ", " : "") +
            (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
            (createdDate != null ? "createdDate=" + createdDate + ", " : "") +
            (lastModifiedBy != null ? "lastModifiedBy=" + lastModifiedBy + ", " : "") +
            (lastModifiedDate != null ? "lastModifiedDate=" + lastModifiedDate + ", " : "") +
            (categoryId != null ? "categoryId=" + categoryId + ", " : "") +
            (categoryTitle != null ? "categoryTitle=" + categoryTitle + ", " : "") +
            (jhiCommonSearchKeywords != null ? "jhiCommonSearchKeywords=" + jhiCommonSearchKeywords + ", " : "") +
            "useOr=" + useOr +
            (and != null ? "and=" + and + ", " : "") +
            (or != null ? "or=" + or + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
