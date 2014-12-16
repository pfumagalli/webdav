package it.could.webdav;

import java.io.File;

/**
 * A resource which cannot be written to or otherwise updated
 */
public class DAVReadOnlyResource extends DAVResource {
    /**
     * <p>Create a new {@link DAVReadOnlyResource} instance.</p>
     *
     * @param repo
     * @param file
     */
    protected DAVReadOnlyResource(DAVRepository repo, File file) {
        super(repo, file);
    }

    @Override
    public DAVOutputStream write() {
        throw new DAVException(403, "Read Only", this);
    }

    @Override
    public void copy(DAVResource dest, boolean overwrite, boolean recursive) throws DAVMultiStatus {
        throw new DAVException(403, "Read Only", this);
    }

    @Override
    public void delete() throws DAVMultiStatus {
        throw new DAVException(403, "Read Only", this);
    }

    @Override
    public void makeCollection() {
        throw new DAVException(403, "Read Only", this);
    }

    public static class Factory implements DAVResourceFactory {
        @Override
        public DAVResource getResource(DAVRepository repo, File file) {
            return new DAVReadOnlyResource(repo,file);
        }
    }
}
