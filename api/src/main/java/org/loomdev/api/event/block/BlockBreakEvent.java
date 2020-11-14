package org.loomdev.api.event.block;

import org.jetbrains.annotations.NotNull;
import org.loomdev.api.block.BlockPointer;
import org.loomdev.api.event.Cancellable;
import org.loomdev.api.event.EventCause;

/**
 * Fired when a block in the world is broken by an interaction.
 * The block will not change state if this event is cancelled.
 *
 * This event is fired when:
 * <ul>
 * <li>A player breaks a block in the world</li>
 * <li>An Ender Dragon destroys a block when mob griefing is enabled</li>
 * <li>An Enderman steals a block when mob griefing is enabled</li>
 * </ul>
 */
public class BlockBreakEvent extends BlockEvent implements Cancellable {

    private final EventCause cause;
    private boolean dropItems;
    private boolean cancelled;

    public BlockBreakEvent(EventCause cause, BlockPointer block) {
        super(block);
        this.cause = cause;
    }

    @NotNull
    public EventCause getCause() {
        return cause;
    }

    public boolean dropItems() {
        return dropItems;
    }

    public void setDropItems(boolean flag) {
        this.dropItems = flag;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
